class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int left = 0;
        long sum = 0;
        long maxsum = 0;
        int n = nums.length;
        for(int i=0; i<k; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
            sum += nums[i];
        }

        if(map.size() == k){
            maxsum = Math.max(maxsum,sum);
        }

        for(int i=k; i<n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+ 1);
            }
            else{
                map.put(nums[i],1);
            }

            if(map.containsKey(nums[left])){
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) <=0){
                    map.remove(nums[left]);
                }
            }

            sum += nums[i];
            sum -= nums[left];


            if(map.size() == k){
                maxsum = Math.max(maxsum,sum);
            }
            left++; 
        }
        return maxsum;
    }
}