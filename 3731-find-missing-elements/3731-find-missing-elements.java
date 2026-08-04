class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer>ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-1; i++){
            int curr = nums[i];

            int next = nums[i+1];

            for(int j = curr+1; j<next;j++){
                ans.add(j);
            }
        }

        return ans;

    }
}