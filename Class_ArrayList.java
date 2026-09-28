import java.util.ArrayList;
import java.util.Collections;

public class Class_ArrayList{

    public static int maximumElement(ArrayList<Integer> list){
        int maximum = Integer.MIN_VALUE;
        
        for(Integer num: list){
            maximum = Math.max(maximum, num);
        }
        return maximum;
    }
    public static void swapNumber(ArrayList<Integer> list, int idx1, int idx2){

        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static int mostWater(int height[]){

        int left = 0;
        int right = height.length-1;
        int mostWater = 0;

        while(left<right){
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currArea = minHeight * width;
            mostWater = Math.max(mostWater, currArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return mostWater; 
    }
    public static boolean pairSum(int arr[], int target){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public static boolean sortedRotated(int arr[], int target){
        return false;
    }
    public static void main(String[] args){
        System.out.println("ArrayList Class");

        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(0); list.add(1); // add element O(1)
        list.add(2); list.add(3);
        list.add(4,4); // O(n)
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0)); // get element O(1)
        list.remove(0); // remove element O(n)
        System.out.println(list);
        list.set(2,4); // set element at index O(n)
        System.out.println(list);
        System.out.println(list.contains(3)); // contains element O(n)
        System.out.println("Maximum Element: " + maximumElement(list));

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(0); nums.add(1); nums.add(2);
        swapNumber(nums, 1,2);
        System.out.println(nums);

        // sorting 
        Collections.sort(nums); // ascending order
        System.out.println(nums);
        Collections.sort(nums, Collections.reverseOrder()); // ascending order
        System.out.println(nums);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1); list1.add(2);
        list2.add(3); list2.add(4);
        mainList.add(list1);
        mainList.add(list2);
        
        System.out.println(mainList);

        for(int i = 0; i<mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0; j < currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }

        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(mostWater(height));

        int arr[] = {1,2,3,4,5}; 
        System.out.println(pairSum(arr, 5));

        int sortedRotated[] = {6,5,4,1,2,3};
        System.out.println(sortedRotated(sortedRotated, 5));

    }
}