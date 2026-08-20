class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // int n=nums.length;
        // int subset=(1<<n);
        // List<List<Integer>> ans=new ArrayList<>();
        // for(int num=0;num<=subset-1;num++){
        //     List<Integer> list=new ArrayList<>();
        //     for(int i=0;i<n;i++){
        //         if((num & (1<<i)) != 0){
        //             list.add(nums[i]);
        //         }
        //     }
        //     ans.add(list);
        // }
        // return ans;

        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    static void solve(int[] nums, int index,
                      List<Integer> current,
                      List<List<Integer>> ans) {
        System.out.println(current);

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        List<Integer> take = new ArrayList<>(current);
        take.add(nums[index]);

        solve(nums, index+1, take, ans);

        solve(nums, index+1, current, ans);
    }
}
