class Solution {
    public int countPrimes(int n) {
        boolean[] composite=new boolean[n];

        for(int i=2;i*i<n;i++){
            if(!composite[i]){
                for(int j=i*i;j<n;j+=i){
                    composite[j]=true;
                }
            }
        }

        int count=0;

        for(int i=2;i<n;i++){
            if(!composite[i])
            count+=1;
        }
        return count;
    }
}