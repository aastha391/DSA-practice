class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] indegree=new int[numCourses];
        Arrays.fill(indegree,0);
        for(int i=0;i<numCourses;i++){
            for(int ele:adj.get(i)){
                indegree[ele]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int it=q.poll();
            res.add(it);

            for(int ele:adj.get(it)){
                indegree[ele]--;

                if(indegree[ele]==0){
                    q.add(ele);
                }
            }
        }

        if(res.size()==numCourses){
        int n=res.size();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=res.get(i);
        }
        return ans;
        }
        else{
            return new int[]{};
        }
    }
}