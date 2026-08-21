class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int low=1,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            high=Math.max(high,nums[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(nums,mid,threshold)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    static boolean possible(int[] nums,int div,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/div);
        }

        if(sum<=threshold) return true;
        else return false;
    }
}