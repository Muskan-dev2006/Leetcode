class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        int []freq = new int [26];
        for(int i=0; i<p.length(); i++){
            freq[p.charAt(i)-'a']++;
        }
        int count = p.length();
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(freq[ch-'a'] > 0){
                count--;
            }
            freq[ch - 'a']--;
            r++;
            if(r - l == p.length()){
                if(count == 0){
                    ans.add(l);
                }
                char remove = s.charAt(l);
                freq[remove-'a']++;
                if(freq[remove - 'a'] > 0){
                    count++;
                }
                l++;
            }
        }
        return ans;
    }
}