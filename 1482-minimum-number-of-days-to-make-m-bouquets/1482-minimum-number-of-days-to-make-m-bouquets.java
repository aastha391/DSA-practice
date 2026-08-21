class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<(long)m*k) return -1;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }

    static boolean possible(int[] bloomDay,int day,int m,int k){
        int n=bloomDay.length;
        int count=0;
        int total_bq=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count+=1;
            }
            else{
                total_bq+=count/k;
                count=0;
            }
        }

        total_bq+=count/k;
        if(total_bq>=m) return true;
        else return false;
    }
}