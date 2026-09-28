// import java.util.*;
public class Class_String{

    public static boolean isPalindrome(String string){
        int left = 0;
        int right = string.length()-1;

        while(left<right){
            if(string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static float shortestPath(String path){
        int x = 0;
        int y = 0;
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                y++;
            }else if(path.charAt(i) == 'E'){
                x++;
            }else if(path.charAt(i) == 'S'){
                y--;
            }else{
                x--;
            }
        }
        return (float) Math.sqrt((int) Math.pow(x-0, 2) + (int) Math.pow(y-0, 2)) ;
    }
    public static String subString(String str, int s, int e){
        String subStr = "";
        for(int i = s; i < e; i++){
            subStr += str.charAt(i);
        }
        return subStr;
    }
    public static void main(String[] args){

        // String str1 = "abcd";
        // String str2 = new String("abcd");
        // Strings are immutable ie does not change

        // Scanner sc = new Scanner(System.in);
        // String name1 = sc.next();
        // sc.nextLine(); // Clear the leftover newline/spaces from the buffer!
        // String name2 = sc.nextLine();
        // System.out.println(name1 + " " + name2);
        // sc.close();

        // String fullName = "Ujjwal Kumar";
        // System.out.println(fullName.length());

        //concatenation
        String firstName = "Ujjwal";
        String lastName = "Kumar";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);  
        System.out.println(fullName.charAt(0)); 
        System.out.println(isPalindrome("racecar")); 
        System.out.println(isPalindrome("madam")); 
        System.out.println(shortestPath("WNEENESENNN"));

        // substring
        String str = "HelloWorld";
        System.out.println(subString(str, 0, 5));
        System.out.println(str.substring(0, 5));
    }
}
