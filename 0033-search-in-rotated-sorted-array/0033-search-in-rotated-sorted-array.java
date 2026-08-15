class Solution {
    public int search(int[] nums, int target) {
    //     int pivot=pivot(nums);
    //     if(pivot==-1)
    //     {
    //         return binarysearch(nums,target,0,nums.length-1);
    //     }

    //     if(nums[pivot]==target)
    //     {
    //         return pivot;
    //     }

    //     if(target>=nums[0])
    //     {
    //         return binarysearch(nums,target,0,pivot-1);
    //     }

    //     return binarysearch(nums,target,pivot+1,nums.length-1);
    // }

    // static int pivot(int[] nums)
    // {
    //   int start=0;
    //   int end=nums.length-1;
    //   while(start<=end)
    //   {
    //     int mid=start+(end-start)/2;
    //     if(mid<end && nums[mid]>nums[mid+1])
    //     {
    //         return mid;
    //     }
    //     else if(mid>start && nums[mid]<nums[mid-1])
    //     {
    //         return mid-1;
    //     }
    //     else if(nums[mid]<=nums[start])
    //     {
    //         end=mid-1;
    //     }
    //     else
    //     {
    //         start=mid+1;
    //     }
    //   }
    //   return -1;
    // }

    // static int binarysearch(int[] nums,int target,int start,int end)
    // {
    //   while(start<=end)
    //   {
    //     int mid=start+(end-start)/2;
    //     if(target<nums[mid])
    //     {
    //         end=mid-1;
    //     }
    //     else if(target>nums[mid])
    //     {
    //         start=mid+1;
    //     }
    //     else
    //     {
    //         return mid;
    //     }
    //   }
    //   return -1;

    int low=0,high=nums.length-1;
    while(low<=high){
        int mid=(low+high)/2;

        if(nums[mid]==target){
            return mid;
        }

        if(nums[low]<=nums[mid]){
            if(target>=nums[low] && target<=nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        else{
            if(target>=nums[mid] && target<=nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
    }
    return -1;
     }
}