// import java.util.*;

public class Class_Pattern{
    public static void main(String[] args){

        // ****
        // ***
        // **
        // *
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < 4-i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // data type
        // byte bytes = 8;
        // char ch = 'u';
        // String string = "u";
        // boolean isequal;
        
        // int a = 10;
        // int b = 20;
        // int sum = a + b;
        // System.out.println(sum);

        // this is a comment single line

        /*
        this is a long comment multiple line
         */

        // input in java
        /*
        next for String like Tony
        nextInt for Integer
        nextLine for Statement like Tony Stark
        nextFloat for floating value
        same for byte, double, boolean, short, long
        
         */
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter number: ");
        // int input = sc.nextInt();
        // System.out.println(input);



        // adding using user input
        // int a9 = sc.nextInt();
        // int b9 = sc.nextInt();
        // System.out.println(a9 + b9);
        // System.out.println(a9 * b9);
        // sc.close();

        // type conversion rules:
        // 1. type compativle
        // 2. destination > source type
        // byte - short - int - float - long - double

        // type casting 
        // int marks = (int) (99.99f);
        // System.out.println(marks);

        // char a = 'a';
        // int anum = a;
        // System.out.println(anum);
        // System.out.println((int)(a));

        // int incr = 0;
        // System.out.println(incr);
        // System.out.println(incr++);
        // System.out.println(incr);

        // int incr1 = 0;
        // System.out.println(incr1);
        // System.out.println(++incr1);
        // System.out.println(incr1);

        // for(int i = 0; i<4; i++){
        //     for(int j = 0; j<4; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // int num = 10899;
        // int reversed = 0;
        // while(num > 0){
        //     int rem = num % 10;
        //     reversed = reversed * 10 + rem;
        //     num = num / 10;
        // }
        // System.out.println(reversed);


        // to check whether number is prime or not
    //     int num = 7;
    //     boolean isPrime = true;
    //     for (int i = 2; i < num; i++) {
    //         if (num % i == 0) {
    //             isPrime = false;
    //             break;
    //         }
    //     }
    //     if (isPrime) {
    //         System.out.println("It is prime");
    //     } else {
    //         System.out.println("It is not prime");
    //     }

        // *
        // **
        // ***
        // ****
        char character = 'A';
        for(int i = 0; i<4; i++){
            for(int j = 0; j<=i; j++){
                System.out.print(character++);
            }
            System.out.println();
        }
    }
}