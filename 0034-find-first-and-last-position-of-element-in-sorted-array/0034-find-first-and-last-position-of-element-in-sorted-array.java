class Solution {
    public int[] searchRange(int[] nums, int target) {
    //     int[] ans={-1,-1};
    //     if(nums.length==0)
    //     {
    //         return ans;
    //     }

    //     ans[0]=firstoccurence(nums,target);
    //     ans[1]=lastoccurence(nums,target);

    //     return ans;
    // }

    // public int firstoccurence(int nums[],int target)
    // {
    //     int s=0;
    //     int e=nums.length-1;
    //     int ans=-1;
    //     while(s<=e)
    //     {
    //         int mid=(s+e)/2;
    //         if(nums[mid]==target){
    //             ans=mid;
    //             e=mid-1;
    //         }else if(target>nums[mid])
    //         {
    //             s=mid+1;
    //         }else{
    //             e=mid-1;
    //         }
    //     }
    //     return ans;
    // }

    //  public int lastoccurence(int nums[],int target)
    // {
    //     int s=0;
    //     int e=nums.length-1;
    //     int ans=-1;
    //     while(s<=e)
    //     {
    //         int mid=(s+e)/2;
    //         if(nums[mid]==target){
    //             ans=mid;
    //             s=mid+1;
    //         }else if(target>nums[mid])
    //         {
    //             s=mid+1;
    //         }else{
    //             e=mid-1;
    //         }
    //     }
    //     return ans;

    int[] ans=new int[2];
    ans[0]=firstoccurence(nums,target);
    ans[1]=lastoccurence(nums,target);

    return ans;
    }

    static int firstoccurence(int[] nums,int target){
        int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }

      static int lastoccurence(int[] nums,int target){
        int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                ans=mid;
                low=mid+1;;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}