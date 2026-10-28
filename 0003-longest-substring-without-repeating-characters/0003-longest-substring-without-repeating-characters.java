class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []freq = new int[256];
        int n = s.length();
        int l = 0;
        int maxlen = 0;
        for(int r=0; r<n; r++){
            int ch = s.charAt(r);
            freq[ch]++;
            while(freq[ch] > 1){
                freq[s.charAt(l)]--;
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }

        return maxlen;
    }
}