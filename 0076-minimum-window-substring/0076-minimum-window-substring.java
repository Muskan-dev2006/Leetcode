class Solution {
    public String minWindow(String s, String t) {
        int []need = new int [128];
        int left = 0;
        int start = 0;
        int remaining = t.length();

        for(char ch : t.toCharArray()){
            need[ch]++;
        }

        int minlen = Integer.MAX_VALUE;

        for(int right = 0; right<s.length();right++){
            char newchar = s.charAt(right);
            if(need[newchar] > 0){
                remaining--;
            }
            need[newchar]--;

            while(remaining == 0){
                if(right-left+1 < minlen){
                    minlen = right-left+1;
                    start = left;
                }
                char leftchar = s.charAt(left);
                 need[leftchar]++;
                if(need[leftchar] > 0){
                    remaining++;
                }
                left++;
            }
        }  
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);      
    }
}