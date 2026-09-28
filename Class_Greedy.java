import java.util.*;

public class Class_Greedy {
    public static int[] minAbsoluteDifference(int a[], int b[]){
        int pairs[] = new int[4];

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < pairs.length; i++){
            pairs[i] = Math.abs(a[i] - b[i]);
        }
        return pairs;
    }

    public static int indianCoins(int price){
        int deno[] = {2000,500,100,50,20,10,5,2,1};
        int count = 0;

        while(price > 0){
            for(int i = 0; i < deno.length; i++){
                if(deno[i] <= price){
                    price -= deno[i];
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int a[] = {4,1,8,7};
        int b[] = {2,3,6,5};
        System.out.println("Min Absolute Diff:" + Arrays.toString(minAbsoluteDifference(a, b)));
        System.out.println(indianCoins(121));

        int n = 4;
        int m = 6;

        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;
        int cost = 0;

        while(h < costHor.length && v < costVer.length){
            if(costVer[v] <= costHor[h]){ // first horizonatl cut because of min cost 
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }else{
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while(h < costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while(v < costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println(cost);
    }
}
