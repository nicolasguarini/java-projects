import java.util.Scanner;

class Program{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int userChoice;
        String number, convertedNumber;
        
        do{
            System.out.println("1 - Decimal to P754 (single precision)");
            System.out.println("2 - P754 to Decimal (single precision)");
            userChoice = input.nextInt();

            switch(userChoice){
                case 1:
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

    
}

class P754Converter{
    public static String decimalToP754(String number){
        int signBit;
        
        if(number.charAt(0) == '-') //sign bit. 1 if negative, 0 if positive.
            signBit = 1; 
        else
            signBit = 0;

        return null;
    }

    public static String P754ToDecimal(String number){
        //TODO
        return null;
    }
}