class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=prerequisites.length;
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }

        boolean[] vis=new boolean[numCourses];
        boolean[] dfsvis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(check(vis,i,adj,dfsvis)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean check(boolean[] vis,int node,ArrayList<ArrayList<Integer>> adj,boolean[] dfsvis){
        vis[node]=true;
        dfsvis[node]=true;

        for(int ele:adj.get(node)){
            if(!vis[ele]){
                if(check(vis,ele,adj,dfsvis)){
                    return true;
                }
            }
            else if(dfsvis[ele]){
                return true;
            }
        }
        dfsvis[node]=false;
        return false;
    }
}