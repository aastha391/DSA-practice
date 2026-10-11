class Solution {

    static String[] mp = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        solve(new StringBuilder(),0,digits,ans);
        return ans;
    }

    static void solve(StringBuilder b,int idx,String digits,List<String> ans){
        if(idx==digits.length()){
            ans.add(b.toString());
            return;
        }

        int ch=digits.charAt(idx)-'0';
        String str=mp[ch];
        if(str.length()==0){
            solve(b,idx+1,digits,ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            b.append(str.charAt(i));
            solve(b,idx+1,digits,ans);
            b.deleteCharAt(b.length()-1);
        }
    }
}