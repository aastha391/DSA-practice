class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==0) return 0;
        // HashMap<Character,Integer> map=new HashMap<>();
        // int length=Integer.MIN_VALUE;
        // int left=0;
        // for(int right=0;right<s.length();right++){
        //     char ch=s.charAt(right);

        //     if(map.containsKey(ch)){
        //         left=Math.max(left,map.get(ch)+1);
        //     }
        //     map.put(ch,right);

        //     length=Math.max(length,right-left+1);
        // }
        // return length;

        if(s.length()==0) return 0;
        int left=0,length=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            length=Math.max(length,right-left+1);
        }
        return length;
    }
}