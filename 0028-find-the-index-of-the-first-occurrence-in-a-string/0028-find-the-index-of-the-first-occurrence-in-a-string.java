class Solution {
    public int [] findlps(int []lps, int n,String s){
        int i = 1;
        int j=0;
        while(i < n){
            if(s.charAt(j) == s.charAt(i)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if(needle.length() > haystack.length()) return -1;
        int []lps = new int[n];
        findlps(lps,n,needle);
        int first = 0;
        int second = 0;

        while(second < n && first < m){
            char ch1 = haystack.charAt(first);
            char ch2 = needle.charAt(second);
            if(ch1 == ch2){
                first++;
                second++;
            }
            else{
                if(second == 0){
                    first++;
                }
                else{
                    second = lps[second-1];
                }
            }
        }
        if(second == n){
              return first-second;
        }
        return -1;
    }
}