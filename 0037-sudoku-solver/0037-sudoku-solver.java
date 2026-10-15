class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;

                if(board[i][j]=='.'){
                    for(int d=1;d<=9;d++){
                        if(isValid(board,i,j,d)){
                            board[i][j]=(char)(d+'0');
                            if(solve(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board,int r,int c,int d){
        for(int i=0;i<9;i++){
            if(board[r][i]==(char)(d+'0')){
                return false;
            }

            if(board[i][c]==(char)(d+'0')){
                return false;
            }
        }

        int start_i=(r/3)*3;
        int start_j=(c/3)*3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[k+start_i][start_j+l]==(char)(d+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}