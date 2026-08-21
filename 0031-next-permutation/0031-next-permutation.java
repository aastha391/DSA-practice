class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // Find the first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If a decreasing element exists
        if (i >= 0) {

            int j = nums.length - 1;

            // Find element just greater than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Reverse the remaining part
        reverse(nums, i + 1, nums.length - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}