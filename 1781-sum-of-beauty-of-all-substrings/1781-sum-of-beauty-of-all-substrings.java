class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                sum+=maxcount(freq)-mincount(freq);
            }
        }
        return sum;
    }

    static int maxcount(int[] freq){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            max=Math.max(max,freq[i]);
        }
        return max;
    }

    static int mincount(int[] freq){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
            min=Math.min(min,freq[i]);
            }
        }
        return min;
    }

    // static int beauty(String s,int i,int j){
    //     int[] hash=new int[26];
    //     int max=Integer.MIN_VALUE;
    //     int min=Integer.MAX_VALUE;
    //     for(int k=i;k<=j;k++){
    //         char ch=s.charAt(k);
    //         hash[ch-'a']++;
    //     }

    //     for(int freq:hash){
    //         if(freq>0){
    //             max=Math.max(max,freq);
    //             min=Math.min(min,freq);
    //         }
    //     }
    //     return max-min;
    // }
}