import java.util.Scanner;

class P754Converter{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int userChoice;
        
        do{
            System.out.println("1 - Decimal to P754");
            System.out.println("2 - P754 to Decimal");
            userChoice = input.nextInt();

            switch(choice){
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

    public static String DecimalToP754(String number){
        //TODO
    }

    public static String P754ToDecimal(String number){
        //TODO
    }
}