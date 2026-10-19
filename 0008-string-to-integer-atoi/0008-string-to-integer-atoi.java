class Solution {
    public int myAtoi(String s) {
      s=s.trim();
      int sign=1;
      int i=0;
      long result=0;
      while(i<s.length()){
        char ch=s.charAt(i);

        if(i==0 && ch=='-'){
            sign=-1;
        }
        else if(i==0 && ch=='+'){
            sign=1;
        }

        else if(ch-'0'>=0 && ch-'0'<=9){
            result=result*10+ch-'0';

             if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
        }

        else{
            break;
        }
        i++;
      }
      return (int)result*sign;
    }
}