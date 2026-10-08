class Solution {
    public double myPow(double x, int n) {
        // double ans=1.0;
        // long nn=n;
        // if(nn<0) nn=-1*nn;
        // while(nn>0){
        //     if(nn%2==1){
        //         ans=ans*x;
        //         nn=nn-1;
        //     }
        //     else{
        //         x=x*x;
        //         nn=nn/2;
        //     }
        // }

        // if(n<0) ans=(double)1.0/(double)ans;
        // return ans;
        long nn=n;
        return solve(x,nn);
    }

    static double solve(double x,long n){
        if(n==0) return 1;

        if(n<0){
            return 1/solve(x,-n);
        }

        if(n%2==0){
            return solve(x*x,n/2);
        }
            return x*solve(x*x,(n-1)/2);
    }
}