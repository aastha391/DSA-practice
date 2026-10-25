class Solution {
    class Interval{
        int s;
        int e;

        public Interval(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Interval[] arr=new Interval[n];
        for(int i=0;i<n;i++){
            arr[i]=new Interval(intervals[i][0],intervals[i][1]);
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a.e,b.e));

        int count=0;
        int e=arr[0].e;
        for(int i=1;i<n;i++){
            if(arr[i].s>=e){
                e=arr[i].e;
            }
            else{
                count++;
            }
        }

        return count;
    }
}