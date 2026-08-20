class Solution {
    static int Max(int[] piles,int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        return max;
    }

    static int reqTime(int[] piles,int n,int bph){
        int totalhrs=0;
        for(int i=0;i<n;i++){
            totalhrs+=Math.ceil((double)piles[i]/(double)bph);
        }
        return totalhrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
            int n=piles.length;
            int low=1,high=Max(piles,n);
            while(low<=high){
                int mid=(low+high)/2;
                int time=reqTime(piles,n,mid);
                if(time<=h){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            return low;
    }
}