class Solution {
  public int commonFactors(int a, int b) {
    int n = Math.min(a, b);
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (a % i == 0 && b % i == 0)
        ans += 1;
    }
    return ans;
  }
}