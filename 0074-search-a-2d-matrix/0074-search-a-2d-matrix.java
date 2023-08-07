class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=0;
        for(i = 0; i<matrix.length; i++){
            for(j=0; j < matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}