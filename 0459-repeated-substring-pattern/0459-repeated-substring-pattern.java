class Solution {
    public int []findlps(int []lps, int n, String s){
        int i=1; 
        int j =0;
        while(i < n){
            if(s.charAt(i) == s.charAt(j)){
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
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n < 0){
            return false;
        }
        int []lps = new int[n];
        findlps(lps,n,s);
        int len = lps[n-1];

        return (len > 0 && n %(n-len) == 0);
    }
}