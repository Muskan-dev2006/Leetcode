class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int maxlen = 0;
        int prefix = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                prefix += -1;
            }
            else{
                prefix += 1;
            }

            if(map.containsKey(prefix)){
                maxlen = Math.max(maxlen ,i-map.get(prefix));
            }
            else{
                map.put(prefix,i);
            }
        }
        return maxlen;
    }
}