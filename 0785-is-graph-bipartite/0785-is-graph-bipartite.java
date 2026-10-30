class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int m=graph[i].length;
            for(int j=0;j<m;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(color,i,0,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int[] color,int node,int c,ArrayList<ArrayList<Integer>> adj){
        color[node]=c;

        for(int ele:adj.get(node)){
            if(color[ele]==-1){
                if(c==0){
                    if(dfs(color,ele,1,adj)){
                        return true;
                    }
                }
                else{
                    if(dfs(color,ele,0,adj)){
                        return true;
                    }
                }
            }
            else if(color[node]==color[ele]){
                return true;
            }
        }
        return false;
    }
}