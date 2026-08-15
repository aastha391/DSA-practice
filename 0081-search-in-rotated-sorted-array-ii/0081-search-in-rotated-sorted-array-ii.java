class Solution {
    public boolean search(int[] nums, int target) {
    //     int pivot=pivot(nums);
    //     if(pivot==-1)
    //     {
    //         return binarysearch(nums,0,nums.length-1,target);
    //     }
    //     if(nums[pivot]==target)
    //     {
    //         return true;
    //     }
    //     if(target>=nums[0])
    //     {
    //         return binarysearch(nums,0,pivot-1,target);
    //     }
    //     else
    //     {
    //         return binarysearch(nums,pivot+1,nums.length-1,target);
    //     }
    // }

    // static int pivot(int[] nums)
    // {
    //     int start=0;
    //     int end=nums.length-1;
    //     while(start<=end)
    //     {
    //         int mid=start+(end-start)/2;
    //         if(mid<end && nums[mid]>nums[mid+1])
    //         {
    //             return mid;
    //         }
    //         if(mid>start && nums[mid]<nums[mid-1])
    //         {
    //             return mid-1;
    //         }
    //         if(nums[start]==nums[mid] && nums[mid]==nums[end])
    //         {
    //             if(start<end && nums[start]>nums[start+1])
    //             {
    //                 return start;
    //             }
    //             start++;
    //             if(end>start && nums[end]<nums[end-1])
    //             {
    //                 return end;
    //             }
    //             end--;
    //         }
    //         else if(nums[start]<nums[mid] || nums[start]==nums[mid] && nums[mid]>nums[end])
    //         {
    //             start=mid+1;
    //         }
    //         else
    //         {
    //             end=mid-1;
    //         }
    //     }
    //     return -1;
    // }

    // static boolean binarysearch(int[] nums,int start,int end,int target)
    // {
    //     while(start<=end)
    //     {
    //         int mid=start+(end-start)/2;
    //         if(target==nums[mid])
    //         {
    //             return true;
    //         }
    //         else if(target<nums[mid])
    //         {
    //             end=mid-1;
    //         }
    //         else
    //         {
    //             start=mid+1;
    //         }
    //     }
    //     return false;

    int low=0,high=nums.length-1;
    while(low<=high){
        int mid=(low+high)/2;

        if(nums[mid]==target) return true;

        if(nums[low]==nums[mid] && nums[mid]==nums[high]){
            low=low+1;
            high=high-1;
            continue;
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
    return false;
    }
}