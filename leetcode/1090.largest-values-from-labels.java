/*
 * @lc app=leetcode.cn id=1090 lang=java
 *
 * [1090] Largest Values From Labels
 */

// @lc code=start
class Solution {
  class Pair {
    int value;
    int label;

    Pair(int value, int label) {
      this.value = value;
      this.label = label;
    }
  }

  public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
    int n = values.length;
    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
      pairs[i] = new Pair(values[i], labels[i]);
    }
    Arrays.sort(pairs, (a, b) -> b.value - a.value);
    int[] labelCount = new int[20001];
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (numWanted == 0)
        break;
      if (labelCount[pairs[i].label] < useLimit) {
        res += pairs[i].value;
        labelCount[pairs[i].label]++;
        numWanted--;
      }
    }
    return res;
  }
}
// @lc code=end
