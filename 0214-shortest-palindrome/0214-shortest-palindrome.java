class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String str = s+"$"+rev;
        int lps[] = new int[str.length()];
        int i=1;
        int j=0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return rev.substring(0,rev.length()-lps[str.length()-1])+s;
    }
}