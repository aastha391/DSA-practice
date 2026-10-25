class Solution {
    // class Pair{
    //     int r;
    //     int c;

    //     public Pair(int r,int c){
    //         this.r=r;
    //         this.c=c;
    //     }
    // }

    public int numIslands(char[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    int count=0;
    boolean[][] vis=new boolean[n][m];

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]=='1' && !vis[i][j]){
                dfs(i,j,vis,grid,n,m);
                count++;
            }
        }
    }
    return count;
    }

    void dfs(int r,int c,boolean[][] vis,char[][] grid,int n,int m){
        if(r<0 || r>=n || c<0 || c>=m) return;

        if(grid[r][c]=='0' || vis[r][c]) return;

        vis[r][c]=true;

        dfs(r-1,c,vis,grid,n,m);
        dfs(r,c+1,vis,grid,n,m);
        dfs(r+1,c,vis,grid,n,m);
        dfs(r,c-1,vis,grid,n,m);
    }

    // void bfs(int r,int c,boolean[][] vis,char[][] grid,int n,int m){
    //     Queue<Pair> q=new LinkedList<>();
    //     q.add(new Pair(r,c));

    //     while(!q.isEmpty()){
    //         Pair it=q.poll();
    //         int nr=it.r;
    //         int nc=it.c;
    //         vis[nr][nc]=true;

    //         if((nr-1)>=0 && nc<m && grid[nr-1][nc]=='1' && !vis[nr-1][nc]){
    //             vis[nr-1][nc]=true;
    //             q.add(new Pair(nr-1,nc));
    //         }

    //         if(nr<n && nc+1<m && grid[nr][nc+1]=='1' && !vis[nr][nc+1]){
    //             vis[nr][nc+1]=true;
    //             q.add(new Pair(nr,nc+1));
    //         }

    //         if(nr+1<n && nc<m && grid[nr+1][nc]=='1' && !vis[nr+1][nc]){
    //             vis[nr+1][nc]=true;
    //             q.add(new Pair(nr+1,nc));
    //         }

    //         if(nr<n && nc-1>=0 && grid[nr][nc-1]=='1' && !vis[nr][nc-1]){
    //             vis[nr][nc-1]=true;
    //             q.add(new Pair(nr,nc-1));
    //         }
    //     }
    // }
}
