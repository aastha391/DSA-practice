class Solution {
    static long mod=1000000007;
    public int countGoodNumbers(long n) {
        long e=(n+1)/2;
        long o=n/2;

        return (int)((power(5,e)*power(4,o))%mod);
    }

    static long power(long a,long b){
        if(b==0) return 1;

        if(b%2==0){
            return power((a*a)%mod,b/2)%mod;
        }

        return (int)a*power((a*a)%mod,(b-1)/2)%mod;
    }
}