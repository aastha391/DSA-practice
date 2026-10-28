class Solution {
    class Pair{
        int r;
        int c;
        int t;

        public Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int time=0,count=0;

        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }

        while(!q.isEmpty()){
            Pair it=q.poll();
            int r=it.r;
            int c=it.c;
            int t=it.t;

            time=Math.max(time,t);
            if(r-1>=0 && c<m && grid[r-1][c]==1 && !vis[r-1][c]){
                vis[r-1][c]=true;
                q.add(new Pair(r-1,c,t+1));
                count--;
            }

            if(r<n && c+1<m && grid[r][c+1]==1 && !vis[r][c+1]){
                vis[r][c+1]=true;
                q.add(new Pair(r,c+1,t+1));
                count--;
            }

            if(r+1<n && c<m && grid[r+1][c]==1 && !vis[r+1][c]){
                vis[r+1][c]=true;
                q.add(new Pair(r+1,c,t+1));
                count--;
            }

            if(r<n && c-1>=0 && grid[r][c-1]==1 && !vis[r][c-1]){
                vis[r][c-1]=true;
                q.add(new Pair(r,c-1,t+1));
                count--;
            }
        }
        if(count<=0) return time;
        else return -1;
    }
}