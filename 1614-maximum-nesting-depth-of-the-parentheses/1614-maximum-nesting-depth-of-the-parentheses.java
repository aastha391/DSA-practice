class Solution {
    public int maxDepth(String s) {
        int count=0,maxLen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                maxLen=Math.max(maxLen,count);
            }
            if(s.charAt(i)==')'){
                count--;
            }
        }
        return maxLen;
    }
}