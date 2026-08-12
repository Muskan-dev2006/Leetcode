class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int l = 0;
        int maxlen = 0;
        int n = nums.length;
        for(int i=0; i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i]) > k){
                int freq = map.get(nums[l]);
                map.put(nums[l], freq - 1);

                if (freq - 1 == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }
            maxlen = Math.max(maxlen, i-l+1);
        }
        return maxlen;
    }
}