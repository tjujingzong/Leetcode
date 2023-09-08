class Solution {
 public:
  bool isSymmetric(int x) {
    string s = to_string(x);
    int n = s.size();
    if (n % 2 == 1)
      return false;
    int t1 = 0;
    int t2 = 0;
    for (int i = 0; i < n / 2; i++) {
      t1 += s[i] - '0';
      t2 += s[n - i - 1] - '0';
    }
    return t1 == t2;
  }
  int countSymmetricIntegers(int low, int high) {
    int ans = 0;
    for (int i = low; i <= high; i++) {
      if (isSymmetric(i))
        ans++;
    }
    return ans;
  }
};