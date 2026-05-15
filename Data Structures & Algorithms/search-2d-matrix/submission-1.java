class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0, right = matrix.length - 1;
        int rowSize = matrix[0].length - 1;

        while (left <= right){

            int middle = left + (right - left) / 2;

            if (matrix[middle][0] <= target && matrix[middle][rowSize] >= target){
                int rowLeft = 0, rowRight = rowSize;

                while (rowLeft <= rowRight){
                    int middleRow = rowLeft + (rowRight - rowLeft) / 2;

                    if (matrix[middle][middleRow] == target){
                        return true;
                    } else if (matrix[middle][middleRow] < target){
                        rowLeft = middleRow + 1;
                    } else {
                        rowRight = middleRow - 1;
                    }
                }
                return false;
            } else if (matrix[middle][0] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return false;
        
    }
}
