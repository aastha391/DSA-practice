class Solution {
    public String minWindow(String s, String t) {
        int[] hash=new int[256];
        Arrays.fill(hash,0);
        int m=t.length();
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        int l=0,minlen=Integer.MAX_VALUE,sIndex=-1,count=0;
        for(int r=0;r<s.length();r++){

            if(hash[s.charAt(r)]>0){
                count++;
            }

            hash[s.charAt(r)]--;

            while(count==m){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sIndex=l;
                }
                hash[s.charAt(l)]++;

                if(hash[s.charAt(l)]>0){
                    count--;
                }
                l++;
            }
        }

        return sIndex==-1?"":s.substring(sIndex,sIndex+minlen);
    }
}