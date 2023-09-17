class Solution {
 public:
  int sumIndicesWithKSetBits(vector<int>& nums, int k) {
    int ans = 0;
    for (int i = 0; i < nums.size(); i++) {
      int t = i;
      int cnt = 0;
      while (t > 0) {
        if (t % 2 == 1)
          cnt++;
        t /= 2;
      }
      if (cnt == k)
        ans += nums[i];
    }
    return ans;
  }
};