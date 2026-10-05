class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,length=0,maxf=Integer.MIN_VALUE;
        int[] hash=new int[26];
        for(int r=0;r<s.length();r++){
            hash[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,hash[s.charAt(r)-'A']);

            if((r-l+1)-maxf>k){
                hash[s.charAt(l)-'A']--;
                l=l+1;
            }

            if((r-l+1)-maxf<=k){
                length=Math.max(length,r-l+1);
            }
        }
        return length;
    }
}