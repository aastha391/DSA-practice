class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        StringBuilder b=new StringBuilder();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && st.peek()-'0'>num.charAt(i)-'0' && k>0){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }

        while(k>0 && !st.isEmpty()){
            st.pop();
            k=k-1;
        }

        if(st.isEmpty()){
            return "0";
        }

        while(!st.isEmpty()){
            b.append(st.pop());
        }

        while(b.length()>1 && b.charAt(b.length()-1)=='0'){
            b.deleteCharAt(b.length()-1);
        }

        return b.reverse().toString();
    }
}