class Solution {
 public:
  int numberOfPoints(vector<vector<int>>& nums) {
    bool vis[105];
    memset(vis, 0, sizeof(vis));
    int n = nums.size();
    for (int i = 0; i < n; i++) {
      int s = nums[i][0];
      int e = nums[i][1];
      for (int j = s; j <= e; j++) {
        vis[j] = 1;
      }
    }
    int ans = 0;
    for (int i = 0; i < 105; i++) {
      if (vis[i])
        ans++;
    }
    return ans;
  }
};