import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[][] mapp = new int[405][405];
    int[] indgree = new int[405];
    boolean[] vis = new boolean[405];
    int[][] ans = new int[k][k];
    List<Integer> rList = new ArrayList<Integer>();
    for (int i = 0; i < rowConditions.length; i++) {
      if (mapp[rowConditions[i][0]][rowConditions[i][1]] == 1)
        continue;
      mapp[rowConditions[i][0]][rowConditions[i][1]] = 1;
      indgree[rowConditions[i][1]]++;
    }
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= k; j++) {
        if (vis[j])
          continue;
        if (indgree[j] == 0) {
          vis[j] = true;
          rList.add(j);
          for (int l = 1; l <= k; l++) {
            if (mapp[j][l] == 1)
              indgree[l]--;
          }
        }
      }
    }
    if (rList.size() != k)
      return new int[0][0];
    mapp = new int[405][405];
    indgree = new int[405];
    vis = new boolean[405];
    List<Integer> cList = new ArrayList<Integer>();
    for (int i = 0; i < colConditions.length; i++) {
      if (mapp[colConditions[i][0]][colConditions[i][1]] == 1)
        continue;
      mapp[colConditions[i][0]][colConditions[i][1]] = 1;
      indgree[colConditions[i][1]]++;
    }
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= k; j++) {
        if (vis[j])
          continue;
        if (indgree[j] == 0) {
          vis[j] = true;
          cList.add(j);
          for (int l = 1; l <= k; l++) {
            if (mapp[j][l] == 1)
              indgree[l]--;
          }
        }
      }
    }
    if (cList.size() != k)
      return new int[0][0];
    for (Integer i : rList) {
      int x = rList.indexOf(i);
      int y = cList.indexOf(i);
      // System.out.println(i + " " + x + " " + y);
      ans[x][y] = i;
    }
    return ans;
  }
}