class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                sum+=beauty(s,i,j);
            }
        }
        return sum;
    }

    static int beauty(String s,int i,int j){
        int[] hash=new int[26];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            char ch=s.charAt(k);
            hash[ch-'a']++;
        }

        for(int freq:hash){
            if(freq>0){
                max=Math.max(max,freq);
                min=Math.min(min,freq);
            }
        }
        return max-min;
    }
}