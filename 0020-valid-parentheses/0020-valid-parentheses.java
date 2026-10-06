class Solution {
    public boolean isValid(String s) {
    //     Stack<Character> stack=new Stack<>();
    //     for(int i=0;i<s.length();i++)
    //     {
    //         char ch=s.charAt(i);
    //         if(ch=='(' || ch=='{' || ch=='[')
    //         {
    //             stack.push(ch);
    //         }
    //         else
    //         {
    //             if (stack.isEmpty()) {
    //                 return false;
    //             }
    //             char top = stack.pop();
    //             if (!isValid(top, ch)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return stack.isEmpty();
    // }

    // public static boolean isValid(char top,char ch)
    // {
    //      return (top == '(' && ch == ')') ||
    //            (top == '{' && ch == '}') ||
    //            (top== '[' && ch == ']');
    // }

    Stack<Character> st=new Stack<>();
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
            st.push(s.charAt(i));
        }
        else{
            if(st.isEmpty()){
                return false;
            }
            else{
                char ch=st.pop();
                if(s.charAt(i)==')' && ch!='('){
                    return false;
                }
                if(s.charAt(i)==']' && ch!='['){
                    return false;
                }
                if(s.charAt(i)=='}' && ch!='{'){
                    return false;
                }
            }
        }
    }
    if(st.size()!=0){
        return false;
    }
    return true;

    }
}