class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // int n=cardPoints.length;
        // int lsum=0,rsum=0,maxsum=0;
        // for(int i=0;i<k;i++){
        //     lsum+=cardPoints[i];
        // }
        // maxsum=lsum;

        // int rindex=n-1;
        // for(int i=k-1;i>=0;i--){
        //     lsum-=cardPoints[i];
        //     rsum+=cardPoints[rindex--];
        //     maxsum=Math.max(maxsum,lsum+rsum);
        // }
        // return maxsum;

        int n=cardPoints.length;
        int sum=0,maxSum=Integer.MIN_VALUE,minSum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=cardPoints[i];
        }

        if(k==n) return sum;

        int size=n-k;
        int l=0;
        int s=0;
        for(int r=0;r<n;r++){
            s+=cardPoints[r];
            if(r-l+1==size){
                minSum=Math.min(minSum,s);
                s-=cardPoints[l];
                l++;
            }
        }
        maxSum=sum-minSum;
        return maxSum;
    }
}