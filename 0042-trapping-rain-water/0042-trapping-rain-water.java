class Solution {
    public int trap(int[] height) {
        // int n=height.length;
        // if(n==0) return 0;
        // int[] left=new int[height.length];
        // int[] right=new int[height.length];

        // left[0]=height[0];
        // right[n-1]=height[n-1];

        // for(int i=1;i<n;i++){
        //     left[i]=Math.max(left[i-1],height[i]);
        // }

        // for(int i=n-2;i>=0;i--){
        //     right[i]=Math.max(right[i+1],height[i]);
        // }

        // int w=0;
        // for(int i=0;i<n;i++){
        //     w+=Math.min(left[i],right[i])-height[i];
        // }
        // return w;

        int n=height.length;
        if(n==0) return 0;

        int l=0,r=n-1;
        int lmax=0,rmax=0,total=0;
        while(l<r){
            if(height[l]<height[r]){
                if(lmax>height[l]){
                    total+=lmax-height[l];
                }
                else{
                    lmax=height[l];
                }
                l=l+1;
            }
            else{
                if(rmax>height[r]){
                    total+=rmax-height[r];
                }
                else{
                    rmax=height[r];
                }
                r=r-1;
            }
        }
        return total;
    }
}