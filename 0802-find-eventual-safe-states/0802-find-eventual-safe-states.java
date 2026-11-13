class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int ele:graph[i]){
                int u=i;
                int v=ele;
                adj.get(v).add(u);
            }
        }

        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[n];
        Arrays.fill(indegree,0);

        for(int i=0;i<n;i++){
            for(int ele:adj.get(i)){
                indegree[ele]++;
            }
        }

        for(int i=0;i<n;i++){
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

        Collections.sort(res);
        return res;
    }
}