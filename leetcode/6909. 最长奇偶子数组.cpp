class Solution {
 public:
  int longestAlternatingSubarray(vector<int>& nums, int threshold) {
    int ans = 0;
    for (int l = 0; l < nums.size(); l++) {
      int r = l;
      if (nums[l] % 2 == 0 && nums[l] <= threshold) {
        for (; r < nums.size() - 1; r++) {
          if (nums[r] % 2 == nums[r + 1] % 2) {
            break;
          }
          if (nums[r + 1] > threshold) {
            break;
          }
        }
        ans = max(ans, r - l + 1);
      }
    }
    return ans;
  }
};