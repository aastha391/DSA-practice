class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,length=0,count=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                count++;
            }

            if(count<=k){
                length=Math.max(length,r-l+1);
            }

            // while(count>k){
            //     if(nums[l]==0){
            //     count--;
            //     }
            //     l++;
            // }

            if(count>k){
                if(nums[l]==0) count--;
                l++;
            }
        }
        return length;
    }
}