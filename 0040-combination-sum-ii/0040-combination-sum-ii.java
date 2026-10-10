class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);
        solve(new ArrayList<>(),0,candidates,n,0,target,result);
        return result;
    }

    // static void solve(List<Integer> curr,int idx,int[] candidates,int n,int sum,int target,List<List<Integer>> result){
    //     if(idx==n){
    //         if(sum==target){
    //             if(!result.contains(curr)){
    //             result.add(new ArrayList<>(curr));
    //             }
    //             return;
    //         }
    //         else{
    //             return;
    //         }
    //     }

    //     if(candidates[idx]<=target-sum){
    //         curr.add(candidates[idx]);
    //         solve(curr,idx+1,candidates,n,sum+candidates[idx],target,result);
    //         curr.remove(curr.size()-1);
    //     }
    //     solve(curr,idx+1,candidates,n,sum,target,result);
    // }

    static void solve(List<Integer> curr,int start,int[] candidates,int n,int sum,int target,List<List<Integer>> result){
        if(sum==target){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<n;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            if(candidates[i]>target-sum) break;

            curr.add(candidates[i]);
            solve(curr,i+1,candidates,n,sum+candidates[i],target,result);
            curr.remove(curr.size()-1);
        }
    }
}