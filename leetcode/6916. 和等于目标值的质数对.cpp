class Solution {
 public:
  vector<vector<int>> findPrimePairs(int n) {
    vector<vector<int>> ans;
    vector<bool> isPrime(n + 1, true);  // 埃拉托斯特尼筛法
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    for (int i = 0; i <= n / 2; i++) {
      if (isPrime[i] && isPrime[n - i]) {
        ans.push_back({i, n - i});
      }
    }
    return ans;
  }
};
