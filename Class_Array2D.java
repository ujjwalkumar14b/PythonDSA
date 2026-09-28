import java.util.*;

public class Class_Array2D {

    public static void print2D(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " "); 
            }
            System.out.println();
        }
    }

    // Changed return type to int[] to return both row and column indices
    public static int[] search2D(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == target) {
                    return new int[]{i, j}; // Return array with coordinates
                }
            }
        }
        return null; // Target not found
    }
    public static List<Integer> spiralMatrix(int grid[][]){
        ArrayList<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while(top<=bottom && left<=right){

            // traverse top row from left to right
            for(int i = left; i<= right; i++){
                result.add(grid[top][i]);
            }
            top++;

            // traverse right column from top to bottom
            for(int i = top; i<=bottom; i++){
                result.add(grid[i][right]);
            }
            right--;

            // Traverse Bottom Row from right to left (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(grid[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse Left Column from bottom to top (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(grid[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static int[] searchSortedGrid(int sortedGrid[][], int target){
        int row = 0, col = sortedGrid[0].length-1;

        while(row<sortedGrid.length && col>= 0){
            if(sortedGrid[row][col] == target){
                return new int[]{row, col};
            }else if(target < sortedGrid[row][col]){
                col--;
            }else{
                row++;
            }   
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[2][3];
        int row = 2;
        int column = 3;

        System.out.println("Enter 6 integers for a 2x3 matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nMatrix:");
        print2D(matrix);

        // Call search2D instead of passing matrix directly to println
        int target = 3;
        int[] result = search2D(matrix, target);

        if (result != null) {
            System.out.println("\nTarget " + target + " found at row " + result[0] + ", column " + result[1]);
        } else {
            System.out.println("\nTarget " + target + " not found.");
        }
        int grid[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralMatrix(grid));

        int sortedGrid[][] = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(searchSortedGrid(sortedGrid, 7));
        sc.close();
    }
}