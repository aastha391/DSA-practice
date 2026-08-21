class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    static void solve(int[] nums, int index, List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(Arrays.asList(
                Arrays.stream(nums).boxed().toArray(Integer[]::new)
            )));
            return;
        }

        choose(nums, index, index, ans);
    }

    static void choose(int[] nums, int index, int i,
                       List<List<Integer>> ans) {

        if (i == nums.length)
            return;

        swap(nums, index, i);

        solve(nums, index + 1, ans);

        swap(nums, index, i);

        choose(nums, index, i + 1, ans);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}