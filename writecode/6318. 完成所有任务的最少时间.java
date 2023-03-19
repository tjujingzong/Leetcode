import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// 6318. Minimum Time to Complete All Tasks 显示英文描述 

// There is a computer that can run an unlimited number of tasks at the same time. You are given a 2D integer array tasks where tasks[i] = [starti, endi, durationi] indicates that the ith task should run for a total of durationi seconds (not necessarily continuous) within the inclusive time range [starti, endi].

// You may turn on the computer only when it needs to run a task. You can also turn it off if it is idle.

// Return the minimum time during which the computer should be turned on to complete all tasks.

// Example 1:

// Input: tasks = [[2,3,1],[4,5,1],[1,5,2]]
// Output: 2
// Explanation: 
// - The first task can be run in the inclusive time range [2, 2].
// - The second task can be run in the inclusive time range [5, 5].
// - The third task can be run in the two inclusive time ranges [2, 2] and [5, 5].
// The computer will be on for a total of 2 seconds.
// Example 2:

// Input: tasks = [[1,3,2],[2,5,3],[5,6,2]]
// Output: 4
// Explanation: 
// - The first task can be run in the inclusive time range [2, 3].
// - The second task can be run in the inclusive time ranges [2, 3] and [5, 5].
// - The third task can be run in the two inclusive time range [5, 6].
// The computer will be on for a total of 4 seconds.

class Solution {
  public int findMinimumTime(int[][] tasks) {
    Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
    int n = tasks.length;
    boolean[] used = new boolean[2005];
    for (int i = 0; i < n; i++) {
      int start = tasks[i][0];
      int end = tasks[i][1];
      int duration = tasks[i][2];
      for (int j = start; j <= end; j++) {
        if (used[j]) {
          duration--;
        }
        if (duration == 0) {
          break;
        }
      }
      for (int j = end; duration > 0; j--) {
        if (!used[j]) {
          used[j] = true;
          duration--;
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < used.length; i++) {
      if (used[i]) {
        ans++;
      }
    }
    return ans;
  }
}