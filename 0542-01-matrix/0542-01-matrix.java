class Solution {
    class Pair{
        int r;
        int c;
        int d;

        public Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        int[][] dist=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair it=q.poll();
            int r=it.r;
            int c=it.c;
            int d=it.d;

            vis[r][c]=true;
            dist[r][c]=d;

            if(r-1>=0 && mat[r-1][c]==1 && !vis[r-1][c]){
                vis[r-1][c]=true;
                q.add(new Pair(r-1,c,d+1));
            }

            if(c+1<m && mat[r][c+1]==1 && !vis[r][c+1]){
                vis[r][c+1]=true;
                q.add(new Pair(r,c+1,d+1));
            }

            if(r+1<n && mat[r+1][c]==1 && !vis[r+1][c]){
                vis[r+1][c]=true;
                q.add(new Pair(r+1,c,d+1));
            }

            if(c-1>=0 && mat[r][c-1]==1 && !vis[r][c-1]){
                vis[r][c-1]=true;
                q.add(new Pair(r,c-1,d+1));
            }
        }

        return dist;
    }
}