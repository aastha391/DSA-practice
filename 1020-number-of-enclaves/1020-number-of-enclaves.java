class Solution {
    class Pair{
        int r;
        int c;

        public Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Pair it=q.poll();
            int r=it.r;
            int c=it.c;
            vis[r][c]=true;

            if(r-1>=0 && c<m && grid[r-1][c]==1 && !vis[r-1][c]){
                vis[r-1][c]=true;
                q.add(new Pair(r-1,c));
            }

            if(r<n && c+1<m && grid[r][c+1]==1 && !vis[r][c+1]){
                vis[r][c+1]=true;
                q.add(new Pair(r,c+1));
            }

            if(r+1<n && c<m && grid[r+1][c]==1 && !vis[r+1][c]){
                vis[r+1][c]=true;
                q.add(new Pair(r+1,c));
            }

            if(r>=0 && c-1>=0 && grid[r][c-1]==1 && !vis[r][c-1]){
                vis[r][c-1]=true;
                q.add(new Pair(r,c-1));
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}