/*
 * @lc app=leetcode.cn id=2698 lang=cpp
 *
 * [2698] Find the Punishment Number of an Integer
 */

// @lc code=start
class Solution {
 public:
  vector<int> getsplit(int n) {
    vector<int> v;
    v.push_back(n);
    for (int i = 10; i < n; i *= 10) {
      vector<int> v1 = getsplit(n / i);
      for (int j = 0; j < v1.size(); j++) {
        v.push_back(n % i + v1[i]);
      }
    }
    return v;
  }
  bool isPunishmentNumber(int n) {
    int s = n * n;
    vector<int> v;
    v = getsplit(s);
    for (int i = 0; i < v.size(); i++)
      cout << v[i] << " ";
    if (find(v.begin(), v.end(), n) != v.end())
      return true;
    else
      return false;
  }
  int punishmentNumber(int n) {
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (isPunishmentNumber(i))
        ans += i * i;
    }
    return ans;
  }
};
// @lc code=end
