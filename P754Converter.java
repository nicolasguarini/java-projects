import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int userChoice;
        String number, convertedNumber;
        
        do{
            clear();
            System.out.println("1 - Decimal to P754 (single precision)");
            System.out.println("2 - P754 to Decimal (single precision)");
            userChoice = input.nextInt();

            switch(userChoice){
                case 1:
                    clear();
                    System.out.println("Enter a number: ");
                    number = input.next();
                    P754Converter.decimalToP754(number);
                    pause();
                    break;
                case 2: 
                    break;
                case 0:
                    break;
                default: 
                    break;
            }
        }while(userChoice != 0);
    }

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void pause() {
        System.out.println("Press enter to continue...");
        new Scanner(System.in).nextLine();
    }
}

class P754Converter{
    public static String decimalToP754(String number){
        int signBit, intPart, positionsToShift = 0;
        String convertedNumber = "", binaryIntegerPart;

        if(numer.charAt(0) != '-' && number.charAt(0) != '+') //add positive sign if not present
            number = "+" + number;
        
        if(number.charAt(0) == '-') //! 1) Sign bit: 1 if negative, 0 if positive.
            signBit = 1;
        else 
            signBit = 0;

        if(number.indexOf('.') == -1) //adding the decimal part if the number is an integer
            number = number + ".0";

        intPart = Integer.parseInt(number.substring(1, number.indexOf('.')));
        binaryIntegerPart = this.decimalToBinary(intPart); //! 2) Convert the integer part into binary

        positionsToShift = binaryIntegerPart.length - 1;      
        

        return convertedNumber;
    }

    public static String P754ToDecimal(String number){
        String convertedNumber = "";
        return convertedNumber;
    }

    String decimalToBinary(int number){
        String binaryNumber = "";

        return binaryNumber;
    }
}

