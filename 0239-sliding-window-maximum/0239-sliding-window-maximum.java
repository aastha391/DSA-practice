// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int[] ans=new int[n-k+1];
//         Deque<Integer> q=new ArrayDeque<>();
//         int l=0,index=0;
//         for(int r=0;r<nums.length;r++){
//             while(!q.isEmpty() && nums[r]>=nums[q.peekLast()]){
//                 q.removeLast();
//             }

//             q.add(r);
//             if(r-l+1==k){
//                 ans[index++]=nums[q.peekFirst()];

//                 if(q.peekFirst()<=l){
//                  q.removeFirst();
//                 }
//                 l++;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> q = new ArrayDeque<>();

        int l = 0, index = 0;

        for(int r = 0; r < nums.length; r++){

            // Remove smaller elements from the back
            while(!q.isEmpty() && nums[r] >= nums[q.peekLast()]){
                q.removeLast();
            }

            q.add(r);

            // Window becomes larger than k
            if(r-l+1 > k){
                if(q.peekFirst() <= l){
                    q.removeFirst();
                }
                l++;
            }

            // Window size is exactly k
            if(r-l+1 == k){
                ans[index++] = nums[q.peekFirst()];
            }
        }

        return ans;
    }
}