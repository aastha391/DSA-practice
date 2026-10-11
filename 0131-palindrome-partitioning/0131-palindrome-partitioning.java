class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        int n=s.length();
        solve(new ArrayList<>(),0,s,n,result);
        return result;
    }

    static void solve(List<String> curr,int idx,String s,int n,List<List<String>> result){
        if(idx==n){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(ispalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                solve(curr,i+1,s,n,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    static boolean ispalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }
}