class Solution {
 public:
  int countCompleteSubarrays(vector<int>& nums) {
    int ans = 0;
    set<int> s;
    for (int i = 0; i < nums.size(); i++) {
      s.insert(nums[i]);
    }
    int l = 0, r = 0;
    map<int, int> m;
    while (l < nums.size()) {
      while (r < nums.size() && m.size() < s.size()) {
        m[nums[r]]++;
        r++;
      }
      if (m.size() == s.size()) {
        ans += nums.size() - r + 1;
      }
      m[nums[l]]--;
      if (m[nums[l]] == 0) {
        m.erase(nums[l]);
      }
      l++;
    }
    return ans;
  }
};