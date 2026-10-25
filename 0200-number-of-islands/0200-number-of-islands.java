class Solution {
    class Pair{
        int r;
        int c;

        public Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public int numIslands(char[][] grid) {
    //     if (grid == null || grid.length == 0) return 0;

    //     int rows = grid.length;
    //     int cols = grid[0].length;
    //     int count = 0;

    //     for (int r = 0; r < rows; r++) {
    //         for (int c = 0; c < cols; c++) {
    //             if (grid[r][c] == '1') {
    //                 count++;             
    //                 dfs(grid, r, c);     
    //             }
    //         }
    //     }
    //     return count;
    // }

    // private void dfs(char[][] grid, int r, int c) {
    //     if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;

    //     if (grid[r][c] == '0') return;

    //     grid[r][c] = '0';
        
    //     dfs(grid, r + 1, c); // down
    //     dfs(grid, r - 1, c); // up
    //     dfs(grid, r, c + 1); // right
    //     dfs(grid, r, c - 1); // left

    int n=grid.length;
    int m=grid[0].length;
    int count=0;
    boolean[][] vis=new boolean[n][m];

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]=='1' && !vis[i][j]){
                bfs(i,j,vis,grid,n,m);
                count++;
            }
        }
    }
    return count;
    }

    void bfs(int r,int c,boolean[][] vis,char[][] grid,int n,int m){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));

        while(!q.isEmpty()){
            Pair it=q.poll();
            int nr=it.r;
            int nc=it.c;
            vis[nr][nc]=true;

            if((nr-1)>=0 && nc<m && grid[nr-1][nc]=='1' && !vis[nr-1][nc]){
                vis[nr-1][nc]=true;
                q.add(new Pair(nr-1,nc));
            }

            if(nr<n && nc+1<m && grid[nr][nc+1]=='1' && !vis[nr][nc+1]){
                vis[nr][nc+1]=true;
                q.add(new Pair(nr,nc+1));
            }

            if(nr+1<n && nc<m && grid[nr+1][nc]=='1' && !vis[nr+1][nc]){
                vis[nr+1][nc]=true;
                q.add(new Pair(nr+1,nc));
            }

            if(nr<n && nc-1>=0 && grid[nr][nc-1]=='1' && !vis[nr][nc-1]){
                vis[nr][nc-1]=true;
                q.add(new Pair(nr,nc-1));
            }
        }
    }
}
