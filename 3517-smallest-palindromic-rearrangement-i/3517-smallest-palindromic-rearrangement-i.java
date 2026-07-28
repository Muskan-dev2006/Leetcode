class Solution {
    public String smallestPalindrome(String s) {
        int []freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int odd = 0;
        char middle = 0;
        for(int i=0; i<26; i++){
            if(freq[i]%2 !=0){
                odd++;
                middle = (char)('a' + i);
            } 
        }
        if(odd > 1) return "";

        StringBuilder firsthalf = new StringBuilder();
        for(int i=0; i<26; i++){
            for(int j=0; j<freq[i]/2; j++){
                firsthalf.append((char)('a' + i));
            }
        }
        StringBuilder ans = new StringBuilder(firsthalf);

        if (odd == 1) {
            ans.append(middle);
        }
        ans.append(firsthalf.reverse());

        return ans.toString();

    }
}