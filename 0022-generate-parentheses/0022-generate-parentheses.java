// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result=new ArrayList<>();
//         solve(new ArrayList<>(),n,result);
//         return result;
//     }

//     static void solve(List<String> curr,int n,List<String> result){
//         if(curr.size()==2*n){
//             if(isValid(curr)){
//             result.add(String.join("",curr));
//             }
//             return;
//         }

//         curr.add("(");
//         solve(curr,n,result);
//         curr.remove(curr.size()-1);
//         curr.add(")");
//         solve(curr,n,result);
//         curr.remove(curr.size()-1);
//     }

//     static boolean isValid(List<String> curr){
//         int count=0;
//         for(int i=0;i<curr.size();i++){
//             if(curr.get(i).equals("(")){
//                 count+=1;
//             }
//             else{
//                 count-=1;

//             if(count<0) return false;
//             }
//         }

//         return count==0;
//     }
// }

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        solve("",0,0,n,result);
        return result;
    }

    static void solve(String curr,int open,int close,int n,List<String> result){
        if(curr.length()==2*n){
            result.add(curr);
            return;
        }

        if(open<n){
            solve(curr+"(",open+1,close,n,result);
        }

        if(close<open){
            solve(curr+")",open,close+1,n,result);
        }
    }
}