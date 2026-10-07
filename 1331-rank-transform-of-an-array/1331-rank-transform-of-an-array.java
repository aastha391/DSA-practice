class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a!=b){
                return Integer.compare(a[0],b[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });

        for(int i=0;i<arr.length;i++){
            pq.add(new int[]{arr[i],i});
        }

        int rank=1;
        int prev=-1;
        if(!pq.isEmpty()){
            int[] curr=pq.poll();
            int index=curr[1];
            arr[index]=rank;
            prev=curr[0];
        }

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int index=curr[1];
            if(curr[0]!=prev){
                rank++;
                prev=curr[0];
            }
            arr[index]=rank;
        }
        return arr;
    }
}