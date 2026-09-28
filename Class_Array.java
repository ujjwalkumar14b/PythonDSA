import java.util.*;
public class Class_Array {

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int findMax(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    public static void printReversed(int[] arr) {
        System.out.print("Reversed Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printPairs(int[] arr) {
        System.out.println("Pairs in array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static int maxSubarrayBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int maxSubarrayPrefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
    public static int trappingWater(int heights[]){
        int trappedWater = 0;
        int n = heights.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = heights[0];
        rightMax[n-1] = heights[n-1];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(heights[i], leftMax[i-1]);
        }        
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(heights[i], rightMax[i+1]);
        }        
        for(int i = 0; i < n; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - heights[i];
        }
        return trappedWater;
    }
    public static int bestTimeToBuyStocks(int prices[]){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 1; i< prices.length; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    public static int[] bubbleSort(int nums[]){
        int n = nums.length;
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j< n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    public static int[] selectionSort(int nums[]){
        int n = nums.length;
        for(int i = 0; i< n-1; i++){
            int minPos = i;
            for(int j = i+1; j< n-1; j++){
                if(nums[minPos] > nums[j]){
                    minPos = j;
                }
            }
            int temp = nums[minPos];
            nums[minPos] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
    public static int[] insertionSort(int nums[]) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Move elements of nums[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2));

        System.out.println(Arrays.toString(nums1));
        System.out.println(nums2);

        int target = 3;
        System.out.println("Linear Search index: " + linearSearch(nums1, target));
        System.out.println("Max number: " + findMax(nums1));
        System.out.println("Binary Search index: " + binarySearch(nums1, target, 0, nums1.length - 1));

        printReversed(nums1);
        printPairs(nums1);
        System.out.println("Max Subarray (Brute Force): " + maxSubarrayBruteForce(nums1));
        System.out.println("Max Subarray (Prefix Sum): " + maxSubarrayPrefixSum(nums1));

        int[] heights = {4,2,0,6,3,2,5};
        System.out.println(trappingWater(heights));

        int[] prices = {7,1,5,3,6,4};
        System.out.println(trappingWater(prices));

        int[] array = {5,4,1,3,2};
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(array)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(array)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(array)));
        
        Arrays.sort(array); 
        System.out.println("Inbuilt Sort: " + Arrays.toString(array)); 
    }
}