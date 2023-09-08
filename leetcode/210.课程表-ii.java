import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<Integer> ans = new ArrayList<>();
    int[][] map = new int[numCourses][numCourses];
    int[] degree = new int[numCourses];
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      degree[prerequisites[i][0]]++;
      map[prerequisites[i][1]][prerequisites[i][0]] = 1;
    }
    while (true) {
      boolean addnew = false;
      for (int i = 0; i < numCourses; i++) {
        if (visited[i])
          continue;
        if (degree[i] == 0) {
          ans.add(i);
          visited[i] = true;
          addnew = true;
          for (int j = 0; j < numCourses; j++) {
            if (map[i][j] == 1)
              degree[j]--;
          }
        }
      }
      if (!addnew)
        break;
      if (ans.size() == numCourses)
        break;
    }
    if (ans.size() == numCourses) {
      int[] res = new int[numCourses];
      for (int i = 0; i < res.length; i++)
        res[i] = ans.get(i);
      return res;
    }
    return new int[0];
  }
}
// @lc code=end
