class Solution {
    static int base = 10;
    static int mod = 1000000007;
    private static String search(String s, int len){
        Map<Long,Integer> map = new HashMap<>();
        long wh=0;
        for(int i=0;i<len;i++){
            wh = ((wh*base)+(s.charAt(i)-'a'+1))%mod;
        }
        map.put(wh,0);
        long hp = 1;
        for(int i=0;i<len-1;i++){
            hp=(hp*base)%mod;
        }
        for(int i=len;i<s.length();i++){
            wh = (wh - (s.charAt(i-len)-'a'+1)*hp%mod+mod)%mod;
            wh = (wh*base);
            wh = (wh + (s.charAt(i)-'a'+1))%mod;
            int start = i-len+1;
            if(map.containsKey(wh)){
                int prev = map.get(wh);
                if(s.substring(start,start+len).equals(s.substring(prev,prev+len))){
                    return s.substring(start,start+len);
                }
            }
            else{
                map.put(wh,start);
            }
        }
        return null;
    }
    public String longestDupSubstring(String s) {
        String ans="";
        int left = 1;
        int right = s.length()-1;
        while(left<=right){
            int mid = (left+right)/2;
            String temp = search(s,mid);
            if(temp!=null){
                ans = temp;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }
}