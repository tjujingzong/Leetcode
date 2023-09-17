class Solution {
 public:
  int countWays(vector<int>& nums) {
    map<int, int> m;
    for (int i = 0; i < nums.size(); i++) {
      m[nums[i]]++;
    }
    int ans = 0;
    int t = 0;
    int n = nums.size();
    for (auto it = m.begin(); it != m.end(); it++) {
      int cnt = it->second;
      int k = it->first;
      t += cnt;
      if (t > k) {
        auto next_it = std::next(it);
        if (next_it != m.end()) {
          int next = next_it->first;
          if (t < next)
            ans++;
        } else
          ans++;
      }
    }
    if (m.begin()->first != 0)
      ans++;
    return ans;
  }
};