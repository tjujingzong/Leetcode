class Solution {
  public int longestESR(int[] sales) {
    int n = sales.length;
    int[] com = new int[n];
    for (int i = 0; i < n; i++) {
      if (sales[i] > 8)
        com[i] = 1;
      else
        com[i] = -1;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += com[j];
        if (sum >= 1)
          ans = Math.max(ans, j - i + 1);
      }
    }
    return ans;
  }
}