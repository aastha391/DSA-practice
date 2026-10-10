class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result=new ArrayList<>();
        solve(new ArrayList<>(),0,n,arr,0,k,result);
        return result;
    }

    static void solve(List<Integer> curr,int idx,int n,int[] arr,int sum,int k,List<List<Integer>> result){
        if(curr.size()==k || idx==arr.length){
            if(curr.size()==k && sum==n){
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(arr[idx]);
        solve(curr,idx+1,n,arr,sum+arr[idx],k,result);
        curr.remove(curr.size()-1);
        solve(curr,idx+1,n,arr,sum,k,result);
    }
}