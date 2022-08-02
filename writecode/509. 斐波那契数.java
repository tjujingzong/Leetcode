class Solution {
  public int fib(int n) {
    if (n == 0)
      return 0;
    if (n <= 2)
      return 1;
    int f1 = 1, f2 = 1;
    int ans = 0;
    for (int i = 1; i < n - 1; i++) {
      ans = f1 + f2;
      f2 = f1;
      f1 = ans;
    }
    return ans;
  }
}