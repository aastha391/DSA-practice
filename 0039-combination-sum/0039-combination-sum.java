class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int n=candidates.length;
        solve(new ArrayList<>(),0,n,candidates,0,target,result);
        return result;
    }

    static void solve(List<Integer> curr,int idx,int n,int[] candidates,int sum,int target,List<List<Integer>> result){
        if(idx==n){
            if(sum==target){
                result.add(new ArrayList<>(curr));
                return;
            }
            else{
                return;
            }
        }

        if(candidates[idx]<=target-sum){
        curr.add(candidates[idx]);
        solve(curr,idx,n,candidates,sum+candidates[idx],target,result);
        curr.remove(curr.size()-1);
        }
        solve(curr,idx+1,n,candidates,sum,target,result);
    }
}