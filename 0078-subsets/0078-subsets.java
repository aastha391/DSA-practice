// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         // int n=nums.length;
//         // int subset=(1<<n);
//         // List<List<Integer>> ans=new ArrayList<>();
//         // for(int num=0;num<=subset-1;num++){
//         //     List<Integer> list=new ArrayList<>();
//         //     for(int i=0;i<n;i++){
//         //         if((num & (1<<i)) != 0){
//         //             list.add(nums[i]);
//         //         }
//         //     }
//         //     ans.add(list);
//         // }
//         // return ans;
//     }
// }

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        solve(new ArrayList<>(),nums,0,result);
        return result;
    }

    static void solve(List<Integer> curr,int[] nums,int idx,List<List<Integer>> result){
        if(idx==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        solve(curr,nums,idx+1,result);
        curr.remove(curr.size()-1);
        solve(curr,nums,idx+1,result);
    }
}
