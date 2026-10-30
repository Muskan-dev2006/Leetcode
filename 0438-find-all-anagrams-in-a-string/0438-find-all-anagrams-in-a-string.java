class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();

        int []freq1 = new int[26];
        int []freq2 = new int[26];


        int n = s.length();
        int m = p.length();

        if(m > n){
            return ans;
        }
        for(int i=0; i<m; i++){
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
        }
        int l = 0;
        if(matches(freq1,freq2)){
            ans.add(l);
        }
        int r = m;
        while( r < n){
            freq2[s.charAt(l)-'a']--;
            l++;
            freq2[s.charAt(r)-'a']++;
            r++;
            if(matches(freq1,freq2)){
                ans.add(l);
            }
        }
        return ans;
    }
    public boolean matches(int []freq1 , int []freq2){
        for(int i=0; i<26; i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}