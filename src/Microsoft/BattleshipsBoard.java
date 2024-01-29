package Microsoft;
import java.util.*;

//Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of
// the battleships on board.
//Battleships can only be placed horizontally or vertically on board. In other words, they can only
// be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any
// size. At least one horizontal or vertical cell separates between two battleships (i.e., there are
// no adjacent battleships).

public class BattleshipsBoard {
    public boolean isValid(int row, int col, int n ,int m){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    public void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol){
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];
            if(isValid(newRow, newCol, board.length, board[0].length) && vis[newRow][newCol] == 0 && board[newRow][newCol] == 'X'){
                dfs(newRow, newCol, vis, board, delrow, delcol);
            }
        }
    }
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length, count = 0;
        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'X'){
                    dfs(i, j, vis, board, delrow, delcol);
                    count++;
                }
            }
        }
        return count;
    }
}
