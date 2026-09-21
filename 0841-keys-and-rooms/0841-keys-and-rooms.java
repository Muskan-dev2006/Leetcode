class Solution {

    public void dfs(int i, List<List<Integer>>rooms, boolean []vis){
        vis[i] = true;

        for(int num : rooms.get(i)){
            if(!vis[num]){
                dfs(num,rooms,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean []vis = new boolean[n];

        dfs(0,rooms,vis);

        for(int i=0; i<n; i++){
            if(vis[i] == false){
                return false;
            }
        }

        return true;
    }
}