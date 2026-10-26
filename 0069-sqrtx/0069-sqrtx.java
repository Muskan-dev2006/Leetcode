class Solution {
    public int mySqrt(int x) {
        int s = 0;
        int e = x;
        long square = -1;
        long ans = -1;
        while( s <= e){
            long mid = s + (e-s)/2;
            square = mid*mid;
            if(square <= x){
                ans = (int)mid;
                s = (int)mid + 1;
            }
            else{
                e = (int)mid - 1;
            }
        }
        return (int)ans;
    }
}