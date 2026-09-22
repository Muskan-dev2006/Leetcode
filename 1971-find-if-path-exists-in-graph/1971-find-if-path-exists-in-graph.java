class Solution {
    public void dfs(int node, List<List<Integer>>ans, boolean []vis){
        vis[node] = true;

        for(int neigh : ans.get(node)){
            if(!vis[neigh]){
                dfs(neigh,ans,vis);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            ans.add(new ArrayList<>());
        }

        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];


            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        boolean []vis = new boolean[n];
        dfs(source, ans, vis);

        return vis[destination];
    }
}