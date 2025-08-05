class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(); //create adj list
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>()); //initialize inner lists
        }
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v); //adding both ways
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        return dfs(source,destination,adj,vis);
    }
    private boolean dfs(int source,int destination,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        if(source==destination) return true;
        vis[source]=true;

        for(int neighbour:adj.get(source)){
            if(!vis[neighbour]){
                if(dfs(neighbour,destination,adj,vis))
                return true;
            }
        }
    
return false;

}}
        

        