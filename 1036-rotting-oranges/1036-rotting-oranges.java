class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m=grid.length; //row
        int n=grid[0].length;// column of 2d matrix: grid

        Queue<Pair> q=new LinkedList<>(); //queue to pairs of ((i,j),time); i,j are indices of rotten pairs.
        int[][] vis=new int[m][n]; //to mark the rotten oranges and track the fresh oranges left.
        int cntFresh=0; //counting no of fresh oranges
        for(int i=0;i<m;i++){ //traversing grid
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){ //rotten orange found
                    q.add(new Pair(i,j,0)); //add indices of rotten orange, time in queue.
                    vis[i][j]=2; //mark vis as 2 for rotten
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++; //if grid has 1; it is fresh
            }
        }
        int tm=0;
        int drow[]={-1,0,+1,0};
        int dcol[]={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<m &&ncol>=0 &&ncol<n &&vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!= cntFresh) 
        {return -1;}
        return tm;
    }
}
class Pair {
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
