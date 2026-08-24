class Solution {
    public int missingNumber(int[] nums) {
        // int n=nums.length;
        // int actsum=(n*(n+1))/2;
        // int currsum=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //    currsum+=nums[i];
        // }
        // int ans=actsum-currsum;
        // return ans;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            ans=ans^i;
            ans=ans^nums[i];
        }
        return ans;
    }
}