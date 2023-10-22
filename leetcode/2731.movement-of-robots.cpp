/*
 * @lc app=leetcode.cn id=2731 lang=cpp
 *
 * [2731] Movement of Robots
 */

// @lc code=start
class Solution {
 public:
  int sumDistance(vector<int>& nums, string s, int d) {
    vector<long long int> v;
    for (int i = 0; i < nums.size(); i++) {
      if (s[i] == 'L') {
        v.push_back((long long int)nums[i] - d);
      } else if (s[i] == 'R') {
        v.push_back((long long int)nums[i] + d);
      }
    }
    sort(v.begin(), v.end());
    long long int sum = 0;
    for (int i = 1; i < v.size(); i++) {
      sum += v[i] - v[0];
    }
    long long int ans = sum;
    for (int i = 1; i < v.size(); i++) {
      sum -= (v[i] - v[i - 1]) * (v.size() - i);
      ans += sum;
      ans %= 1000000007;
    }
    return ans;
  }
};
// @lc code=end
