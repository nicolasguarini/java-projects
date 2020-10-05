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
                    System.out.println("Enter a number: ");     //-5.8281215
                    number = input.next();
                    System.out.println("IEEE 754: " + P754Converter.decimalToP754(number));
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
        int signBit, intPart, positionsToShift = 0, pad;
        double decimalPart;
        String convertedNumber = "", binaryIntegerPart, binaryDecimalPart, binaryNumber, shiftedBinaryNumber;

        if(number.charAt(0) != '-' && number.charAt(0) != '+') //add positive sign if not present
            number = "+" + number;
        
        if(number.charAt(0) == '-') //! 1) Sign bit: 1 if negative, 0 if positive.
            signBit = 1;
        else 
            signBit = 0;

        if(number.indexOf('.') == -1) //adding the decimal part if the number is an integer
            number = number + ".0";

        intPart = Integer.parseInt(number.substring(1, number.indexOf('.')));
        binaryIntegerPart = Integer.toBinaryString(intPart); //! 2) Convert the integer part into binary

        positionsToShift = binaryIntegerPart.length() - 1; 

        decimalPart = Double.parseDouble("0." + (number.substring(number.indexOf('.') + 1))); 
        binaryDecimalPart =  decimalFractionToBinary(decimalPart); //! 3) Convert the decimal fraction part into binary
        
        binaryNumber = binaryIntegerPart + "." + binaryDecimalPart; //assembling the final binary string

        shiftedBinaryNumber = addChar(charRemoveAt(binaryNumber, binaryNumber.indexOf('.')), '.', 1); //! 4) Shifting the floating point

        convertedNumber = signBit + " " + Integer.toBinaryString(127 + positionsToShift) + " " + shiftedBinaryNumber.substring(2); //assembling the final P754 string 

        return convertedNumber;
    }

    static String decimalFractionToBinary(double decimalFraction){
        int fractBit;
        String binary = "";

        for(int i = 0; i < 22; i++){ //the precision after decimal point will be 10 bits
            decimalFraction *= 2;
            fractBit = (int) decimalFraction;

            if(fractBit == 1){
                decimalFraction -= fractBit;
                binary += "1";
            }
            else
                binary += "0";
        }

        return binary;
    }

    static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
    } 

    public static String P754ToDecimal(String number){
        String convertedNumber = "";
        return convertedNumber;
    }
}

