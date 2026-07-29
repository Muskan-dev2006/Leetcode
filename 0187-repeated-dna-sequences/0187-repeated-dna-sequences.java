class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>ans = new ArrayList<>();
        HashMap<Character,Integer>map = new HashMap<>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);

        HashSet<Integer>set1 = new HashSet<>();
        HashSet<String>set2 = new HashSet<>();

        int hash = 0;
        for(int i=0; i<s.length();i++){
            hash = (hash <<2) | map.get(s.charAt(i));
            hash = hash &(1 << 20)-1;
            if(i>=9){
                if(set1.contains(hash)){
                    String sub = s.substring(i-9, i+1);
                    if(!set2.contains(sub)){
                        set2.add(sub);
                        ans.add(sub);
                    }
                }
                else{
                    set1.add(hash);
                }
            }
            
        }
        
        return ans;
    }
}