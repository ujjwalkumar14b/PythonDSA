import java.util.*;

public class Class_Queue {

    public static void printNonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void interleave2Halves(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i = 0; i < size/2; i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2);
        q.add(3); q.add(4);
        q.add(5); q.add(6);
        q.add(7); q.add(8);
        System.out.println(q);

        interleave2Halves(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
        printNonRepeating("aabccxb");
        System.out.println();


        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(3);
        dq.addFirst(2);
        dq.addFirst(1);
        dq.addLast(4);

        while(!dq.isEmpty()){
            System.out.print(dq.removeFirst() + " ");
        }
        System.out.println();
    }
}
