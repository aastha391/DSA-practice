class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int d1=Math.abs(a-x);
            int d2=Math.abs(b-x);
            if(d1!=d2){
                return Integer.compare(d2,d1);
            }
            else{
                return Integer.compare(b,a);
            }
        });

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);

            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        Collections.sort(list);
        return list;
    }
}