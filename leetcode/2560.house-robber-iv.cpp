class Solution {
  bool check(vector<int>& nums, int k, int mx) {
    int cnt = 0, n = nums.size();
    for (int i = 0; i < n; i++) {
      if (nums[i] <= mx) {
        cnt++;  // 偷 nums[i]
        i++;    // 跳过下一间房子
      }
    }
    return cnt >= k;
  }

 public:
  int minCapability(vector<int>& nums, int k) {
    int left = 0, right = *max_element(nums.begin(), nums.end());
    while (left + 1 < right) {  // 开区间写法
      int mid = left + (right - left) / 2;
      (check(nums, k, mid) ? right : left) = mid;
    }
    return right;
  }
};
