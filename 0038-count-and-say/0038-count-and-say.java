class Solution {
    public String countAndSay(int n) {
        String prev="1";
        if(n == 1){
            return prev;
        }
        for(int i=2; i<=n;i++){
            StringBuilder sb = new StringBuilder();
            int k = 0;
            while(k < prev.length()){
                char ch = prev.charAt(k);
                int count = 0;
                while(k < prev.length() && prev.charAt(k) == ch){
                    count++;
                    k++;
                }

                sb.append(count);
                sb.append(ch);
            }
            prev = sb.toString();
        }
        return prev;
    }
}