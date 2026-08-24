class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int []arr=new int[nums1.length+nums2.length];
    //     int i=0,j=0,k=0;
    //    while(i<nums1.length && j<nums2.length)
    //    {
    //     if(nums1[i]<nums2[j])
    //     {
    //         arr[k++]=nums1[i];
    //         i++;
    //     }
    //     else
    //     {
    //         arr[k++]=nums2[j];
    //         j++;
    //     }
    //    }
    //    while(i<nums1.length){
    //     arr[k++]=nums1[i];
    //     i++;
    //    }
    //    while(j<nums2.length){
    //     arr[k++]=nums2[j];
    //     j++;
    //    }
    //    int len=arr.length;
    //     if(len%2!=0)
    //     {
    //         return arr[((len+1)/2)-1];
    //     }
    //     else{
    //         return (arr[(len/2)-1]+arr[((len/2)+1)-1])/2.0;
    //     }

    if(nums2.length<nums1.length) return findMedianSortedArrays(nums2,nums1);

    int n1=nums1.length;
    int n2=nums2.length;
    int low=0;
    int high=n1;
    while(low<=high){
      int cut1=(low+high)/2;
      int cut2=(n1+n2+1)/2-cut1;
      int left1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
      int left2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];

      int right1=cut1==n1?Integer.MAX_VALUE:nums1[cut1];
      int right2=cut2==n2?Integer.MAX_VALUE:nums2[cut2];

      if(left1<=right2 && left2<=right1){
        if((n1+n2)%2==0){
            return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
        }
        else{
            return Math.max(left1,left2);
        }
      }
      else if(left1>right2){
        high=cut1-1;
      }
      else{
        low=cut1+1;
      }
    }
    return 0.0; 
    }
}