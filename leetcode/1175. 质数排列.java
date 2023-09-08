class Solution {
  public int numPrimeArrangements(int n) {
    if (n <= 2)
      return 1;
    int m = 1000000000 + 7;
    int numprim = 0;
    for (long i = 2; i <= n; i++) {
      long k = 2;
      for (k = 2; k < Math.sqrt(i + 1); k++) {
        if (i % k == 0)
          break;
      }
      if (k == Math.ceil(Math.sqrt(i + 1))) {
        // System.out.println(i);
        numprim++;
      }
    }
    long ans = 1;
    int left = n - numprim;
    for (int i = 2; i <= numprim; i++) {
      ans *= i;
      ans = ans % m;
    }
    for (int i = 2; i <= left; i++) {
      ans *= i;
      ans = ans % m;
    }
    return (int) ans;
  }
}