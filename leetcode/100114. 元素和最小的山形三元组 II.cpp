class Solution {
 public:
  int minimumSum(vector<int>& nums) {
    int n = nums.size();

    vector<int> minLeft(n);   // 存储每个位置左侧的最小值
    vector<int> minRight(n);  // 存储每个位置右侧的最小值
    int ans = INT_MAX;

    minLeft[0] = nums[0];
    for (int i = 1; i < n; i++) {
      minLeft[i] = min(minLeft[i - 1], nums[i - 1]);
    }

    minRight[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      minRight[i] = min(minRight[i + 1], nums[i + 1]);
    }

    for (int i = 1; i < n - 1; i++) {
      if (nums[i] > minLeft[i] && nums[i] > minRight[i]) {
        ans = min(ans, nums[i] + minLeft[i] + minRight[i]);
      }
    }

    return ans == INT_MAX ? -1 : ans;
  }
};
