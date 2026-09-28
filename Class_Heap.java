import java.util.PriorityQueue;
import java.util.Comparator;

class Class_Heap{
    public static void main(String[] args) {
        System.out.println("Heap/ Priority Queue");

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(4);
        pq.add(5);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
    }
}