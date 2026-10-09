class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=n-1;
        int mod=1000000007;
        int result=0;
        int[] pow=new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }

        while(l<=r){
            if(nums[l]+nums[r]<=target){
                result=(result+pow[r-l])%mod;
                l++;
            }
            else{
                r--;
            }
        }
        return result;
    }
}