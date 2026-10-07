class Solution {
    public boolean isPalindrome(String s) {
    //     StringBuilder b=new StringBuilder();
    //     for(int i=0;i<s.length();i++)
    //     {
    //        if(Character.isLetterOrDigit(s.charAt(i)))
    //        {
    //           b.append(Character.toLowerCase(s.charAt(i)));
    //        }
    //     }
    //    String original=b.toString();
    //    String reverse=b.reverse().toString();
    //    if(!original.equals(reverse))
    //    {
    //     return false;
    //    }
    //    return true;

    int n=s.length();
    s=s.toLowerCase();
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        if(Character.isLetterOrDigit(ch)){
            sb.append(ch);
        }
    }
    s=sb.toString();
    int l=0,r=s.length()-1;
    return solve(l,r,s,n);
    }

    static boolean solve(int l,int r,String s,int n){
        if(l>=r){
            return true;
        }

        if(s.charAt(l)!=s.charAt(r)) return false;

        return solve(l+1,r-1,s,n);
    }
}