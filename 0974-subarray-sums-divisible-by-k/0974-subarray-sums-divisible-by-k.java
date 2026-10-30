class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int rem = 0;
        int sum = 0;
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            rem = ((sum%k)+k)%k;

            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0) + 1);
        }
        return count;
    }
}