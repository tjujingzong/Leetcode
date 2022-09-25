class Solution {
  public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
    int n = temperatureA.length;
    int[] diffa = new int[n - 1];
    int[] diffb = new int[n - 1];
    for (int i = 1; i < n; i++) {
      if (temperatureA[i] - temperatureA[i - 1] > 0)
        diffa[i - 1] = 1;
      else if (temperatureA[i] - temperatureA[i - 1] < 0)
        diffa[i - 1] = -1;
      else
        diffa[i - 1] = 0;
      if (temperatureB[i] - temperatureB[i - 1] > 0)
        diffb[i - 1] = 1;
      else if (temperatureB[i] - temperatureB[i - 1] < 0)
        diffb[i - 1] = -1;
      else
        diffb[i - 1] = 0;
    }
    int i = 0, last = -1;
    int ans = 0;
    while (i < n - 1) {
      if (diffb[i] != diffa[i]) {
        last = i;
      }
      ans = Math.max(i - last, ans);
      i++;
    }
    return ans;
  }
}