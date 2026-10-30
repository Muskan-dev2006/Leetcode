class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0;
        int e =  n*m -1 ;

        while(s<=e){
            int mid = s+(e-s)/2;
            int rowi = mid/n;
            int coli = mid%n;

            if(matrix[rowi][coli] == target){
                return true;
            }
            else if(matrix[rowi][coli] < target){
                s = mid + 1;
            }
            else{
                e = mid-1;
            }
        }
        return false;
    }
}