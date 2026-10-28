class Solution {
    // class Pair{
    //     int r;
    //     int c;

    //     public Pair(int r,int c){
    //         this.r=r;
    //         this.c=c;
    //     }
    // }
    static int n,m;
    public void solve(char[][] board) {
        // int n=board.length;
        // int m=board[0].length;
        // Queue<Pair> q=new LinkedList<>();
        // boolean[][] vis=new boolean[n][m];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(i==0 || j==0 || i==n-1 || j==m-1){
        //             if(board[i][j]=='O'){
        //                 q.add(new Pair(i,j));
        //                 vis[i][j]=true;
        //             }
        //         }
        //     }
        // }

        // while(!q.isEmpty()){
        //     Pair it=q.poll();
        //     int r=it.r;
        //     int c=it.c;

        //     if(r-1>=0 && board[r-1][c]=='O' && !vis[r-1][c]){
        //         q.add(new Pair(r-1,c));
        //         vis[r-1][c]=true;
        //     }

        //     if(c+1<m && board[r][c+1]=='O' && !vis[r][c+1]){
        //         q.add(new Pair(r,c+1));
        //         vis[r][c+1]=true;
        //     }

        //     if(r+1<n && board[r+1][c]=='O' && !vis[r+1][c]){
        //         q.add(new Pair(r+1,c));
        //         vis[r+1][c]=true;
        //     }

        //     if(c-1>=0 && board[r][c-1]=='O' && !vis[r][c-1]){
        //         q.add(new Pair(r,c-1));
        //         vis[r][c-1]=true;
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(board[i][j]=='O' && !vis[i][j]){
        //             board[i][j]='X';
        //         }
        //     }
        // }


        n=board.length;
        m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j] && i==0 || j==0 || i==n-1 || j==m-1){
                    dfs(board,i,j,vis);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    static void dfs(char[][] board,int r,int c,boolean[][] vis){
        if(r<0 || r>=n || c<0 || c>=m) return;

        if(board[r][c]=='X' || vis[r][c]) return;

        vis[r][c]=true;
        dfs(board,r-1,c,vis);
        dfs(board,r,c+1,vis);
        dfs(board,r+1,c,vis);
        dfs(board,r,c-1,vis);
    }
}