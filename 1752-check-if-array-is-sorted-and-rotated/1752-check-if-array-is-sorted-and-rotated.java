class Solution {
    public boolean check(int[] nums) {
        return solve(0,nums,0);
    }

    static boolean solve(int i,int[] nums,int count){
        if(count>1){
            return false;
        }

        if(i==nums.length){
            return true;
        }

        if(nums[i]>nums[(i+1)%nums.length]){
            count++;
        }

        return solve(i+1,nums,count);
    }
}