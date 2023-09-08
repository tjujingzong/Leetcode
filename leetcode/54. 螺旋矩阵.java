import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> ans = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    int dir = 0;
    int nowrol = 0;
    int nowcolume = 0;
    while (ans.size() < m * n) {
      ans.add(matrix[nowrol][nowcolume]);
      matrix[nowrol][nowcolume] == 101;
      if (dir == 0) {
        if (nowcolume == n - 1 || matrix[nowrol][nowcolume + 1] == 101) {
          dir = 1;
          nowrol += 1;
        } else {
          nowcolume += 1;
        }
        continue;
      }
      if (dir == 1) {
        if (nowrol == m - 1 || matrix[nowrol + 1][nowcolume] == 101) {
          nowcolume -= 1;
          dir = 2;
        } else {
          nowrol += 1;
        }
        continue;
      }
      if (dir == 2) {
        if (nowcolume == 0 || matrix[nowrol][nowcolume - 1] == 101) {
          nowrol -= 1;
          dir = 3;
        } else {
          nowcolume -= 1;
        }
        continue;
      }
      if (dir == 3) {
        if (nowrol == 0 || matrix[nowrol - 1][nowcolume] == 101) {
          nowcolume++;
          dir = 0;
        } else {
          nowrol -= 1;
        }
        continue;
      }
    }
    return ans;
  }
}