class Solution {
  public int tribonacci(int n) {
    if (n == 0)
      return 0;
    if (n <= 2)
      return 1;
    int ans = 0;
    int f0 = 0, f1 = 1, f2 = 1;
    for (int i = 1; i <= n - 2; i++) {
      ans = f0 + f1 + f2;
      f0 = f1;
      f1 = f2;
      f2 = ans;
    }
    return ans;
  }
}