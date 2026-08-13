class Solution {
    public boolean isPalindrome(int x) {
        int c,rev=0,n=x;
        while(x>0){
        c=x%10;
        rev=rev*10+c;
        x=x/10;
        }
        if(n==rev){
            return true;
        }
        else{
            return false;
        }
    }
}