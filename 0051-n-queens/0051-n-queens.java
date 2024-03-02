class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] leftRow = new int[n];
        int[] upperDiagnol = new int[2*n -1];
        int[] lowerDiagnol = new int[2*n -1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        
        solve(0, board, ans, leftRow, upperDiagnol, lowerDiagnol);
        return ans;
        
    }
    
    public void solve(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] upperDiagnol, int[] lowerDiagnol){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        
        
        for(int row = 0; row < board.length; row++){
            int n = board[0].length;
            if(leftRow[row] == 0 && lowerDiagnol[row+col] == 0 && upperDiagnol[n-1 + col-row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagnol[row+col] = 1;
                upperDiagnol[n-1 + col-row] = 1;
                solve(col+1, board, ans, leftRow, upperDiagnol, lowerDiagnol);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagnol[row+col] = 0;
                upperDiagnol[n-1 + col-row] = 0;
            }
        }
        
    }
    
     public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}