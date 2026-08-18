class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
        int count=0;
        while(ans!=0){
            if((ans&1) == 1) count+=1;
            ans>>=1;
        }
        return count;
    }
}