class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String str = s + "$" + rev;

        int n = str.length();
        int []lps = new int [n];

        int i = 1;
        int j = 0;
        while(i < n){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if(ch1 == ch2){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j==0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return rev.substring(0,rev.length()-lps[n-1]) + s;
    }
}