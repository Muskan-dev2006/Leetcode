class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;

        while(left<=right && top <= bottom){
            for(int i=left; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int j=top; j<=bottom;j++){
                list.add(matrix[j][right]);
            }
            right--;
            if(top <= bottom){
                for(int k=right; k>=left; k--){
                    list.add(matrix[bottom][k]);
                }
                bottom--;
            }
            if(left <= right){
                for(int l=bottom ; l>=top; l--){
                    list.add(matrix[l][left]);
                }
                left++;
            }
        }
        return list;
    }
}