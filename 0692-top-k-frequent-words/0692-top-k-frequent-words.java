class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String[]> pq=new PriorityQueue<>((a,b)->{
            if(!a[1].equals(b[1])){
                return Integer.compare(Integer.parseInt(a[1]),Integer.parseInt(b[1]));
            }
            else{
                return b[0].compareTo(a[0]);
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String key=entry.getKey();
            int value=entry.getValue();
            pq.add(new String[]{key,String.valueOf(value)});

            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll()[0]);
        }

        Collections.reverse(list);

        return list;
    }
}