public class Class_Bit {
    public static String evenOrOdd(int num){
        if((num & 1) == 0){
            return "Even";
        }
        return "Odd";
    }
    // Bit Manipulation Operations
    // Get ith bit     
    public static int getith(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }
        return 1;
    }
    // Set ith bit
    // Clear ith bit
    public static void main(String[] args){
        System.out.println("AND: " + (5 & 6));
        System.out.println("OR: " + (5 | 6));
        System.out.println("XOR: " + (5 ^ 6));
        System.out.println("1's: " + (~5)); // -6
        System.out.println("Num to Binary: " + Integer.toBinaryString(5) );
        System.out.println("Left Shift: " + (5<<2));
        System.out.println("Right Shift: " + (5>>2));
        System.out.println(evenOrOdd(5));

        System.out.println(getith(5, 2));
        
    }
}
