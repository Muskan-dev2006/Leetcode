class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        int sum = 0;
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        for(int i=0; i<n; i++){
            for(int j=0; j<boxTypes[i][0];j++){
                if(truckSize > 0){
                    sum += boxTypes[i][1];
                    truckSize--;
                }
            }
        }
        return sum;
    }
}