class Solution {
    public int[] searchRange(int[] nums, int target) {
    // int[] ans=new int[2];
    // ans[0]=firstoccurence(nums,target);
    // ans[1]=lastoccurence(nums,target);

    // return ans;
    // }

    // static int firstoccurence(int[] nums,int target){
    //     int low=0,high=nums.length-1;
    //     int ans=-1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;

    //         if(nums[mid]==target){
    //             ans=mid;
    //             high=mid-1;
    //         }
    //         else if(nums[mid]<target){
    //             low=mid+1;
    //         }
    //         else{
    //             high=mid-1;
    //         }
    //     }
    //     return ans;
    // }

    //   static int lastoccurence(int[] nums,int target){
    //     int low=0,high=nums.length-1;
    //     int ans=-1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;

    //         if(nums[mid]==target){
    //             ans=mid;
    //             low=mid+1;;
    //         }
    //         else if(nums[mid]<target){
    //             low=mid+1;
    //         }
    //         else{
    //             high=mid-1;
    //         }
    //     }
    //     return ans;

    int lb=lowerbound(nums,target);
    if(lb==nums.length || nums[lb]!=target){
        return new int[] {-1,-1};
    }
    else{
        return new int[] {lb,upperbound(nums,target)-1};
    }

    }

    static int lowerbound(int[] nums,int target){
        int low=0,high=nums.length-1;
        int ans=nums.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    static int upperbound(int[] nums,int target){
        int low=0,high=nums.length-1;
        int ans=nums.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}