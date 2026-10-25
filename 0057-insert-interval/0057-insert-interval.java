class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] res=new int[n+1][2];
        int i=0,j=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            res[j][0]=intervals[i][0];
            res[j][1]=intervals[i][1];
            i++;
            j++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res[j][0]=newInterval[0];
        res[j][1]=newInterval[1];
        j++;

        while(i<n){
            res[j][0]=intervals[i][0];
            res[j][1]=intervals[i][1];
            i++;
            j++;
        }

        return Arrays.copyOf(res,j);
    }
}