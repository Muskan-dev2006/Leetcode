class Solution {
    public int[] dailyTemperatures(int[] temprature) {
        Stack<Integer>st = new Stack<>();
        int n = temprature.length;
        int []temp = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temprature[st.peek()] <= temprature[i]){
                st.pop();
            }
            if(st.isEmpty()){
                temp[i] = 0;
            }
            else{
                temp[i] = st.peek()-i;
            }
            st.push(i);
        }
        return temp;
    }
}