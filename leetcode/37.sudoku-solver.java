import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
  ArrayList<Integer> x;
  ArrayList<Integer> y;
  char[][] ans = new char[9][9];

  public void solveSudoku(char[][] board) {
    HashSet<Integer>[] rowsets = new HashSet[9];
    HashSet<Integer>[] colsets = new HashSet[9];
    HashSet<Integer>[] gridsets = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      rowsets[i] = new HashSet<Integer>();
      colsets[i] = new HashSet<Integer>();
      gridsets[i] = new HashSet<Integer>();
      for (int j = 1; j <= 9; j++) {
        rowsets[i].add(j);
        colsets[i].add(j);
        gridsets[i].add(j);
      }
    }
    x = new ArrayList<>();
    y = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          x.add(i);
          y.add(j);
        } else {
          int num = board[i][j] - '0';
          rowsets[i].remove(num);
          colsets[j].remove(num);
          int r = i / 3;
          int c = j / 3;
          gridsets[r * 3 + c].remove(num);
        }
      }
    }
    dfs(rowsets, colsets, gridsets, 0, board);

    for (int k = 0; k < 9; k++)
      for (int j = 0; j < 9; j++)
        board[k][j] = ans[k][j];
    return;

  }

  private void dfs(HashSet<Integer>[] rowsets, HashSet<Integer>[] colsets, HashSet<Integer>[] gridsets, int i,
      char[][] board) {
    if (i == x.size()) {
      for (int k = 0; k < 9; k++)
        for (int j = 0; j < 9; j++)
          ans[k][j] = board[k][j];
      return;
    }

    int px = x.get(i);
    int py = y.get(i);
    HashSet<Integer> temp = new HashSet<Integer>();
    temp.addAll(rowsets[px]);
    for (Integer num : temp) {
      int r = px / 3;
      int c = py / 3;
      int g = r * 3 + c;
      if (colsets[py].contains(num) && gridsets[g].contains(num)) {
        rowsets[px].remove(num);
        colsets[py].remove(num);
        gridsets[g].remove(num);
        board[px][py] = (char) ('0' + num);
        dfs(rowsets, colsets, gridsets, i + 1, board);
        rowsets[px].add(num);
        colsets[py].add(num);
        gridsets[g].add(num);
        board[px][py] = '.';
      }
    }
  }
}
// @lc code=end
