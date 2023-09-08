class Solution {
  public int edgeScore(int[] edges) {
    int max = 0;
    int ans = 0;
    int n = edges.length;
    int[] score = new int[n];
    for (int i = 0; i < n; i++) {
      score[edges[i]] += i;
      if (score[edges[i]] > max) {
        max = score[edges[i]];
        ans = edges[i];
      }
    }
    for (int i = 0; i < n; i++) {
      if (score[i] == max)
        return i;
    }
    return ans;
  }
}