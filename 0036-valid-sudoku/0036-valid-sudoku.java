class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean [][]rowvisited = new boolean[9][9];
        boolean [][]colvisited = new boolean[9][9];
        boolean [][]boxvisited = new boolean[9][9];

        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                char ch = board[row][col];

                if(ch=='.'){
                    continue;
                }

                int digit = ch-'1';

                int box = (row/3)*3 +  col/3;

                if(rowvisited[row][digit] || colvisited[col][digit] || boxvisited[box][digit]){
                    return false;
                }

                rowvisited[row][digit] = true;
                colvisited[col][digit] = true;
                boxvisited[box][digit] = true;
            }
        }
        return true;
    }
}