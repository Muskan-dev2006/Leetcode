class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int left =0;
        int n = piles.length;
        int right = n-1;
        int max = 0;
        while(left < right){
            right --;
            max += piles[right];

            left++;
            right--;
        }

         return max;
    }
}