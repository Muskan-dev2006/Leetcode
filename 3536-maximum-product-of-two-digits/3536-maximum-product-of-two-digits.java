class Solution {
    public int maxProduct(int n) {

        int num = n;
        ArrayList<Integer>ans = new ArrayList<>();
        while(num!=0){
            ans.add(num%10);
            num = num/10;
        }
        Collections.sort(ans);
        return ans.get(ans.size()-1)*ans.get(ans.size()-2);

    }
}