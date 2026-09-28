import java.util.*;

public class Class_Stack {

    // Custom Stack using ArrayList
    static class StackA {
        private ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (isEmpty()) return -1;
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (isEmpty()) return -1;
            return list.get(list.size() - 1);
        }
    }

    // Node class for StackB
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Custom Stack using LinkedList
    static class StackB {
        private Node head = null;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) return -1;
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return head.data;
        }
    }

    // Prints stack elements without destroying the stack
    public static void print(Stack<Integer> s) {
        for (int i = s.size() - 1; i >= 0; i--) {
            System.out.println(s.get(i));
        }
    }

    // Pushes element to the bottom using a helper stack
    public static void pushBottom(Stack<Integer> s, int data) {
        Stack<Integer> helper = new Stack<>();
        while (!s.isEmpty()) {
            helper.push(s.pop());
        }
        s.push(data);
        while (!helper.isEmpty()) {
            s.push(helper.pop());
        }
    }

    // Reverses string using Stack
    public static String reverseString(String string) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            s.push(string.charAt(i));
        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // Reverses a stack in-place using recursion
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]){
        
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void greaterElement(int arr[], int nextGreater[]){
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean validParenthesis(String str){
        
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{'  || ch == '['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') ||
                (s.peek() == '{' && ch == '}') ||
                (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean duplicateParentheses(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }

    public static int maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        // Next Smaller Right
        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next Smaller Left
        s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // Current Area
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushBottom(s, 0);
        System.out.println("Stack contents top-to-bottom:");
        print(s); // Outputs: 3, 2, 1, 0

        System.out.println("\nReversing stack in-place...");
        reverseStack(s);
        print(s); // Outputs: 0, 1, 2, 3

        String reversed = reverseString("Ujjwal Kumar");
        System.out.println("\nReversed string: " + reversed);

        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        
        for(int i = 0; i< span.length; i++){
            System.out.print(span[i] + " ");
        }
        System.out.println();

        int arr[] = {6,8,0,1,3};
        int nextGreater[] = new int[arr.length];
        greaterElement(arr, nextGreater);

        for(int i = 0; i< nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

        System.out.println("Valid Parenthesis: " + validParenthesis("(){}[]"));
        System.out.println("Valid Parenthesis: " + validParenthesis("[{()}]"));
        System.out.println("Valid Parenthesis: " + validParenthesis("[{(}}]"));
        System.out.println("Duplicate Parenthesis: " + duplicateParentheses("((a+b))")); //true
        System.out.println("Duplicate Parenthesis: " + duplicateParentheses("(a+b)")); //false

        int heights[] = {2,1,5,6,2,3};
        System.out.println("Max Area in Histogram: " + maxArea(heights));
    }
}