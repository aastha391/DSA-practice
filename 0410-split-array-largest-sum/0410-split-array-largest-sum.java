class Solution {
    public int splitArray(int[] nums, int k) {
        // int start=0;
        // int end=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     start=Math.max(start,nums[i]);
        //     end+=nums[i];
        // }
        // while(start<end){
        //     int mid=start+(end-start)/2;
        //     int sum=0;
        //     int peices=1;
        //     for(int num:nums){
        //         if(sum+num>mid)
        //         {
        //             sum=num;
        //             peices++;
        //         }
        //         else{
        //             sum+=num;
        //         }
        //     }

        //     if(peices>k)
        //     {
        //         start=mid+1;
        //     }
        //     else
        //     {
        //         end=mid;
        //     }
        // }
        // return end;

        int n=nums.length;
        int low=Integer.MIN_VALUE,high=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }

        while(low<=high){
            int mid=(low+high)/2;
            if(possible(nums,mid,k,n)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    static boolean possible(int[] nums,int mid,int k,int n){
        int sum=0,count=1;
        for(int i=0;i<n;i++){
            if(nums[i]+sum>mid){
                count+=1;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }

        if(count>k) return false;
        else return true;
    }
}