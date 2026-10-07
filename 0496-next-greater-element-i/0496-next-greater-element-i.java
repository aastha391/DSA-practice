class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int [] arr=new int[nums1.length];
    
    //     for(int i=0;i<nums1.length;i++)
    //     {
    //         int foundindex=-1;
    //         for(int j=0;j<nums2.length;j++)
    //         {
    //             if(nums1[i]==nums2[j])
    //             {
    //                foundindex=j;
    //                break;
    //             }
    //         }

    //     int nextgreater=-1;
    //     for(int k=foundindex+1;k<nums2.length;k++)
    //     {
    //         if(nums2[k]>nums1[i]){
    //             nextgreater=nums2[k];
    //             break;
    //         }
    //     }
    //     arr[i]=nextgreater;;
    // }
    // return arr;

    int[] ans=new int[nums1.length];
    Stack<Integer> st=new Stack<>();
    ArrayList<Integer> list=new ArrayList<>();
    for(int num:nums1){
        list.add(num);
    }
    for(int i=nums2.length-1;i>=0;i--){
        if(list.indexOf(nums2[i])!=-1){
            int index=list.indexOf(nums2[i]);
            if(!st.isEmpty()){
                if(st.peek()>nums2[i]){
                    ans[index]=st.peek();
                }
                else{
                    while(!st.isEmpty() && st.peek()<nums2[i]){
                        st.pop();
                    }
                    if(!st.isEmpty()) 
                      ans[index]=st.peek();
                    else
                      ans[index]=-1;
                }
            }
            else{
                ans[index]=-1;
            }
            st.push(nums2[i]);
        }
        else{
            st.push(nums2[i]);
        }
    }
    return ans;
}
}