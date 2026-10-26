class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int n = boxTypes.length;
        int count = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            count = Math.min(truckSize, boxTypes[i][0]);
            sum += count*boxTypes[i][1];

             truckSize -= count;

            if(truckSize == 0){
                break;
            }
        }
        return sum;
    }
}