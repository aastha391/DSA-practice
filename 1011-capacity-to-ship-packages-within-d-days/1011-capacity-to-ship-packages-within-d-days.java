class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(weights,days,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    static boolean possible(int[] weights,int days,int cap){
        int day=1,load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>cap){
                day+=1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }

        if(day<=days) return true;
        else return false;
    }
}