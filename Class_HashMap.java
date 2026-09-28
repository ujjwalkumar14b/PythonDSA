import java.util.HashMap;

public class Class_HashMap {
    
    public static void main(String[] args){
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(1,1);
        hm.put(2,4);
        hm.put(3,9);
        hm.put(4,16);
        System.out.println(hm);
        System.out.println(hm.get(2));
        System.out.println(hm.containsKey(2));
        System.out.println(hm.remove(2));
        System.out.println(hm.containsKey(2));
    }
}
