class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
    //     List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
    //     list.sort((a,b)->b.getValue().compareTo(a.getValue()));
    //     int[] arr=new int[k];
    //    for(int i=0;i<k;i++)
    //    {
    //     arr[i]=list.get(i).getKey();
    //    }
    //    return arr;

    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        int key=entry.getKey();
        int value=entry.getValue();

        pq.add(new int[]{key,value});

        if(pq.size()>k){
            pq.poll();
        }
    }

    int[] arr=new int[k];
    for(int i=0;i<k;i++){
        arr[i]=pq.poll()[0];
    }
    return arr;
    }
}