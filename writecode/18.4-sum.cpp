class Solution {
 public:
  vector<vector<int>> fourSum(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    vector<vector<int>> ans;
    int n = nums.size();
    for (int a = 0; a < n - 3; a++) {  // 枚举第一个数
      long long x = nums[a];           // 使用 long long 避免溢出
      if (a > 0 && x == nums[a - 1])
        continue;  // 跳过重复数字
      if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target)
        break;  // 优化一
      if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
        continue;                            // 优化二
      for (int b = a + 1; b < n - 2; b++) {  // 枚举第二个数
        long long y = nums[b];
        if (b > a + 1 && y == nums[b - 1])
          continue;  // 跳过重复数字
        if (x + y + nums[b + 1] + nums[b + 2] > target)
          break;  // 优化一
        if (x + y + nums[n - 2] + nums[n - 1] < target)
          continue;  // 优化二
        int c = b + 1, d = n - 1;
        while (c < d) {  // 双指针枚举第三个数和第四个数
          long long s = x + y + nums[c] + nums[d];  // 四数之和
          if (s > target)
            d--;
          else if (s < target)
            c++;
          else {  // s == target
            ans.push_back({(int)x, (int)y, nums[c], nums[d]});
            for (c++; c < d && nums[c] == nums[c - 1]; c++)
              ;  // 跳过重复数字
            for (d--; d > c && nums[d] == nums[d + 1]; d--)
              ;  // 跳过重复数字
          }
        }
      }
    }
    return ans;
  }
};
