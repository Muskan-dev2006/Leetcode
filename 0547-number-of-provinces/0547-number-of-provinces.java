class Solution {
    public void dfs(int node, List<List<Integer>>adjList, boolean [] visited){
        visited[node] = true;

        for(int neighbour : adjList.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,adjList,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>>adjList = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean []visited = new boolean[n];

        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i,adjList,visited);
            }
        }

        return count;
    }
}