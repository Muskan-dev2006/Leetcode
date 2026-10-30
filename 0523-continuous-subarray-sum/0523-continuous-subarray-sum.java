class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<n; i++){
            sum += nums[i];
            int rem = sum%k;
            if(map.containsKey(rem)){

                if(i-map.get(rem) > 1){
                    return true;
                }
            }
            else{
                map.put(rem,i);
            }
        }
        return false;
    }
}