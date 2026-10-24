class Solution {
    public int peakValleyDifference(int[] nums) {
        int sp=0,sv=0;
        int d=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                sp+=nums[i];
            }

            if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                sv+=nums[i];
            }
        }
        return sp-sv;
    }
}