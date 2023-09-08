class Solution {
 public:
  long long getMaxFunctionValue(vector<int>& a, long long k) {
    int n = a.size();
    int f[n][36];
    long long w[n][36];
    for (int i = 0; i < n; ++i) {
      f[i][0] = a[i];
      w[i][0] = i;
    }
    for (int j = 1; j < 36; ++j) {
      for (int i = 0; i < n; ++i) {
        f[i][j] = f[f[i][j - 1]][j - 1];
        w[i][j] = w[i][j - 1] + w[f[i][j - 1]][j - 1];
      }
    }
    long long res = 0;
    for (int i = 0; i < n; ++i) {
      long long cur = 0;
      int pos = i;
      for (int j = 0; j < 36; ++j) {
        if ((k >> j) & 1) {
          cur += w[pos][j];
          pos = f[pos][j];
        }
      }
      res = max(res, cur + pos);
    }
    return res;
  }
};
