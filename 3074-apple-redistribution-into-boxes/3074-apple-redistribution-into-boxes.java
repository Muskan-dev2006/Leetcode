class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for(int num : apple){
            total += num;
        }
        int len = capacity.length;
        int use = 0;
        for(int i=len-1; i>=0;i--){
            total = total - capacity[i];
            use++;
            if(total <=0 ){
                return use;
            }
        }
        return use;
    }
}