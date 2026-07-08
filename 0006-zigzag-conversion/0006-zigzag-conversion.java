class Solution {
    public String convert(String s, int numRows) {
        String []arr = new String [numRows];
        Arrays.fill(arr,"");
        if(numRows == 1){
            return s;
        }
        int currrow = 0;
        boolean down = true;
        for(int i=0; i<s.length();i++){
            arr[currrow]+=s.charAt(i);
            if(i!=0){
                 if(currrow == numRows-1 || currrow == 0){
                    down = !down;
                }
            }
            if(down){
                currrow++;
            }
            else{
                currrow--;
            }
           
        }
        String str="";
        for(int i=0; i<arr.length;i++){
            str+=arr[i];
        }
        return str;
    }
}