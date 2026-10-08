class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] ns=nse(arr);
        int[] ps=pse(arr);
        long total=0;
        int mod=1000000007;

        for(int i=0;i<arr.length;i++){
            long right=ns[i]-i;
            long left=i-ps[i];

            total=(total+right*left*arr[i])%mod;
        }
        return (int)total;
    }

    static int[] nse(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i]=st.peek();
            }
            else{
                ans[i]=arr.length;
            }
            st.push(i);
        }
        return ans;
    }

    static int[] pse(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i]=st.peek();
            }
            else{
                ans[i]=-1;
            }
            st.push(i);
        }
        return ans;
    }
}