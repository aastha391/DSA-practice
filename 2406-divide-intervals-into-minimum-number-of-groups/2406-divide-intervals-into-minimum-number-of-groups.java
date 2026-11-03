class Solution {
    public int minGroups(int[][] intervals) {
      int n=intervals.length;
      int[] arr=new int[n];
      int[] dep=new int[n];
      for(int i=0;i<n;i++){
        arr[i]=intervals[i][0];
        dep[i]=intervals[i][1];
      }

      Arrays.sort(arr);
      Arrays.sort(dep);
      int i=0,j=0,count=0,maxCount=0;
      while(i<n){
        if(arr[i]<=dep[j]){
            count++;
            i++;
        }
        else{
            count--;
            j++;
        }

        maxCount=Math.max(maxCount,count);
      }

      return maxCount;
    }
}