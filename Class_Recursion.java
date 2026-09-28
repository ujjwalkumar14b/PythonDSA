public class Class_Recursion {

    public static void printInc(int n) {
        if (n == 0) { 
            return;
        }
        printInc(n - 1);           
        System.out.print(n + " "); 
    }
    public static void printDec(int n) {
        if (n == 0) { 
            return;
        }
        System.out.print(n + " "); 
        printDec(n - 1);           
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int sumNo(int n){
        if(n==1){
            return 1;
        }
        return n+sumNo(n-1);
    }
    public static void fibonacci(int n, int a, int b) {
        if (n == 0) {
            return;
        }
        System.out.print(a + " ");
        fibonacci(n - 1, b, a + b);
    }
    public static boolean sortedArray(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return sortedArray(arr, i+1);
    }
    public static int firstOccurence(int nums[], int i, int target){
        if(i == nums.length){
            return -1;
        }
        if(nums[i] == target){
            return i;
        }
        return firstOccurence(nums, i+1, target);
    }
    public static int lastOccurence(int nums[], int i, int target){
        if(i < 0){
            return -1;
        }
        if(nums[i] == target){
            return i;
        }
        return lastOccurence(nums, i-1, target);
    }
    public static int xpowN(int x, int n){
        if(n == 1){
            return x;
        }
        return x * xpowN(x, n-1);
    }
    public static int tillingProblem(int n){
        if(n==1 || n ==2){
            return n;
        }
        return tillingProblem(n-1) + tillingProblem(n-2);
    }
    public static void removeDuplicates(String str, int i, StringBuilder newStr, boolean map[]){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(i);
        if(map[currChar - 'a'] == true){
            removeDuplicates(str, i+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicates(str, i+1, newStr.append(currChar), map);
        }
    }
    public static int friendsPairing(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }
    public static void stringWithoutConsecutive1s(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        stringWithoutConsecutive1s(n-1, 0, str+"0");
        if(lastPlace == 0){
            stringWithoutConsecutive1s(n-1, 1, str+"1");
        }
    }

    public static void main(String[] args) {
        System.out.print("Increasing: ");
        printInc(10); 
        System.out.println();
        System.out.print("Decreasing: ");
        printDec(10);
        System.out.println();
        System.out.println("Factorial: " + factorial(5));
        System.out.println("Sum of n natural no: " + sumNo(5));
        fibonacci(5, 0, 1);
        System.out.println();
        int nums[] = {0,1,2,3,3,4,5};
        System.out.println(sortedArray(nums, 0));
        System.out.println(firstOccurence(nums, 0, 3));
        System.out.println(lastOccurence(nums, nums.length-1, 3));
        System.out.println(xpowN(4, 4));
        System.out.println(tillingProblem(4));
        removeDuplicates("aabbcc", 0, new StringBuilder(""), new boolean[26]);
        System.out.println(friendsPairing(3));
        stringWithoutConsecutive1s(3, 0, "");
    }
}
