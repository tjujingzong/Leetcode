class Solution {
 public:
  int minAbsoluteDifference(vector<int>& nums, int x) {
    int ans = INT_MAX, n = nums.size();
    set<int> s = {INT_MIN / 2, INT_MAX};  // 哨兵
    for (int i = x; i < n; i++) {
      s.insert(nums[i - x]);
      int y = nums[i];
      auto it = s.lower_bound(y);
      ans = min(ans, min(*it - y, y - *--it));
    }
    return ans;
  }
};
