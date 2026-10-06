class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int []ans = new int[n];
        int m = nums1.length;
        Stack<Integer>st = new Stack<>();
        for(int i=n-1; i>=0;i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = -1;
            }
            st.push(nums2[i]);
        }
        for(int j=0; j<m; j++){
            for(int k=0; k<n; k++){
                if(nums1[j] == nums2[k]){
                    nums1[j] = ans[k];
                    break;
                }
            }
        }
        return nums1;
    }
}