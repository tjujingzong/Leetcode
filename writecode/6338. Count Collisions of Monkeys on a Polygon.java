class Solution {
  int mod = 1000000007;

  public int monkeyMove(int n) {
    int ans = 1;
    // 利用快速幂求解2的n次方
    ans = fastPow(2, n);
    return ((int) ans - 2 + mod) % mod;
  }

  public int fastPow(int a, int b) {
    long ans = 1;
    long base = a;
    while (b != 0) {
      if ((b & 1) == 1) {
        ans = (ans * base) % mod;
      }
      base = (base * base) % mod;
      b >>= 1;
    }
    return (int) ans;
  }
}