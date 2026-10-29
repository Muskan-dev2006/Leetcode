class StockSpanner {
    Stack<Integer>st;
    ArrayList<Integer>arr;
    public StockSpanner() {
        st = new Stack<>();
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
         arr.add(price);
        int i = arr.size()-1;
        while(!st.isEmpty() && arr.get(st.peek())<=price){
            st.pop();
        }
        int span;
        if(st.isEmpty()){
            span = i+1;
        }
        else{
            span = i-st.peek();
        }
        st.push(i);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */