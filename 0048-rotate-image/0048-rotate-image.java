class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m;i++){
            for(int j=i; j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k=0; k<m;k++){
            reverse(matrix[k]);
        }
    }
    private void reverse(int []arr){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int num = arr[i];
            arr[i] = arr[j];
            arr[j] = num;
            i++;
            j--;
        }
    }
}