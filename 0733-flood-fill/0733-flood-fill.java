class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int ic=image[sr][sc];
        boolean[][] vis=new boolean[n][m];
        dfs(image,vis,ic,sr,sc,n,m,color);

        return image;
    }

    static void dfs(int[][] image,boolean[][] vis,int ic,int r,int c,int n,int m,int color){
        if(r<0 || r>=n || c<0 || c>=m || vis[r][c]) return;

        if(image[r][c]!=ic) return;

        if(image[r][c]==ic){
            vis[r][c]=true;
            image[r][c]=color;
        }

        dfs(image,vis,ic,r-1,c,n,m,color);
        dfs(image,vis,ic,r,c+1,n,m,color);
        dfs(image,vis,ic,r+1,c,n,m,color);
        dfs(image,vis,ic,r,c-1,n,m,color);
    }
}