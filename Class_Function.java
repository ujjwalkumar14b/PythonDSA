public class Class_Function {

    public static int sum(int a, int b){ // parameters
        return a + b;
    }
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }    
    public static boolean isPrime(int n){
        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void primesRange(int n){
        for(int i = 2; i<n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
    public static void binToDec(int n){
        int power = 0;
        int decimal = 0;

        while(n>0){
            int last = n % 10;
            decimal = decimal + (last * (int) Math.pow(2,power));
            power++;
            n = n/10;
        }
        System.out.println(decimal);
    }
    public static void DecToBin(int n){
        int power = 0;
        int binary = 0;

        while(n>0){
            int last = n % 2;
            binary = binary + (last * (int) Math.pow(10,power));
            power++;
            n = n/2;
        }
        System.out.println(binary);
    }
    public static void main(String[] args) {
        
        // System.out.println(sum(1,2)); // arguments
        // System.out.println(factorial(5));
        // System.out.println(isPrime(16));
        // primesRange(16);
        binToDec(101);
        DecToBin(5);
    }
}
