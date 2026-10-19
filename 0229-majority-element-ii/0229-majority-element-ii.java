class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int freq=n/3;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>freq){
                list.add(entry.getKey());
            }
        }

        return list;
    }
}