class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        solve(new ArrayList<>(),0,n,nums,result);
        return result;
    }

    static void solve(List<Integer> curr,int idx,int n,int[] nums,List<List<Integer>> result){
        if(idx==n){
            if(!result.contains(curr)){
                result.add(new ArrayList<>(curr));
                return;
            }
            else{
                return;
            }
        }

        curr.add(nums[idx]);
        solve(curr,idx+1,n,nums,result);
        curr.remove(curr.size()-1);
        solve(curr,idx+1,n,nums,result);
    }
}