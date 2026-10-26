class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 0;
        int e = num;

        long sq = 0;

        while( s<=e){
            long mid = s + (e-s)/2;
            sq = mid * mid;
            if(sq == num){
                return true;
            }
            else if(sq < num){
                s = (int)mid + 1;
            }
            else{
                e = (int)mid-1;
            }
        }
        return false;
    }
}