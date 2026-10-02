class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==0) return 0;
        // int left=0,length=0;
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int right=0;right<s.length();right++){
        //     if(map.containsKey(s.charAt(right))){
        //         left=Math.max(left,map.get(s.charAt(right))+1);
        //     }
        //     map.put(s.charAt(right),right);
        //     length=Math.max(length,right-left+1);
        // }
        // return length;

        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        int l=0,length=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            
            if(hash[ch]!=-1){
                l=Math.max(l,hash[ch]+1);
            }
            
            hash[ch]=r;
            length=Math.max(length,r-l+1);
        }
        return length;
    }
}