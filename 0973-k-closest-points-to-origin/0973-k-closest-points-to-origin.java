class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int dist1=a[0]*a[0]+a[1]*a[1];
            int dist2=b[0]*b[0]+b[1]*b[1];

            return Integer.compare(dist2,dist1);
    });

    for(int[] point:points){
        pq.add(point);

        if(pq.size()>k){
            pq.poll();
        }
    }

    int[][] arr=new int[k][2];
    int i=0;
    while(!pq.isEmpty()){
        int[] point=pq.poll();
        arr[i][0]=point[0];
        arr[i][1]=point[1];
        i++;
    }

    return arr;
    }
}