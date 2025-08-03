class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution{
private void bfs(int row,int col, int[][] vis,char[][] grid){ //bfs function to traverse from the starting node to search its neighbours that form an island
    vis[row][col]=1; //mark the visited node as 1 

    Queue<Pair> q=new LinkedList<Pair>(); //queue stores a pair of(row,col)
    q.add(new Pair(row, col)); //add the node into queue
    int n=grid.length; //finding row in a grid
    int m=grid[0].length; //col in grid

    while(!q.isEmpty()){ //till the queue doesn't get empty
        int ro=q.peek().first; //peek thr row of node to bt removed
        int co=q.peek().second; //peeking col of node
        q.remove();//remove the node

        int[] dRow = {-1, 0, 1, 0}; // Up, Right, Down, Left
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
                int nrow = ro + dRow[i];
                int ncol = co + dCol[i];

        /*traverse the neighbours in all 8 directions and mark them if its a land

        for(int delrow=-1;delrow<=1;delrow++){ //shortcut formula for identifying the row of all neighbours.
            for(int delcol=-1;delcol<=1;delcol++){ //trick for col of all neighbours
                int nrow=ro+delrow;//corresponding row of neighbour
                int ncol=co+delcol;
                //checking if row,col of neigh. are in valid range of grid and is a land*/
                if(nrow>=0 &&nrow<n &&ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length; //row
        int m=grid[0].length; //col
        int[][] vis=new int[n][m]; //2d visited array

        int cnt=0;//to count no of islands
        for(int row=0;row<n;row++){ //traversing the 2d-grid from start to end as {row,col} pair   
            for(int col=0;col<m;col++){ //col-> 0 to n
                if(vis[row][col]==0 && grid[row][col]=='1'){ //if a node{row,col} is not visited and it is a land: it forms a starting node of an island.
                    cnt++; //a starting node founds indicates an island hence cnt it
                    bfs(row,col,vis,grid); //traverse from the starting node and using bfs find its neighbours.
                }
            }
        }
        return cnt; // return the no. of islands found
    }
}