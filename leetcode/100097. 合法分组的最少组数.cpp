class Solution {
 public:
  int minGroupsForValidAssignment(vector<int>& nums) {
    unordered_map<int, int> mp;
    for (int num : nums)
      mp[num]++;
    int mn = INT_MAX;
    for (const auto& [num, cnt] : mp) {
      mn = min(mn, cnt);
    }
    for (int a = mn; a > 0; --a) {
      int res = 0, ok = 1;

      for (const auto& [_, cnt] : mp) {
        int b = a + 1;
        int g = (cnt + b - 1) / b;
        int r = cnt - g * a;
        if (r >= 0) {
          res += (cnt + b - 1) / b;
        } else {
          ok = 0;
          break;
        }
      }
      if (ok)
        return res;
    }
    return -1;
  }
};
