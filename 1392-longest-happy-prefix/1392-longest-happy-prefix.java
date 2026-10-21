class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int []lps = new int[n];
        int i=1;
        int j=0;
        while(i < n){
            if(s.charAt(i) == s.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j==0){
                    lps[i++] = 0;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }
}