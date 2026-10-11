class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height=new int[matrix[0].length];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }
                else{
                    height[j]=0;
                }
            }

            int area=largestRectangle(height);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

    static int largestRectangle(int[] height){
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()]>height[i]){
                int el=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea,height[el]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int el=st.pop();
            int nse=height.length;
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,height[el]*(nse-pse-1));
        }

        return maxArea;
    }
}