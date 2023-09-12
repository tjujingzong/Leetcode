class Solution {
 public:
  int ans = 0x3f3f3f3f;
  int minimumMoves(vector<vector<int>>& grid) {
    vector<int> v;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j] == 0) {
          v.push_back(i * 3 + j);
        }
      }
    }
    dfs(v, 0, 0, grid);
    return ans;
  }
  void dfs(vector<int>& v, int cnt, int i, vector<vector<int>>& grid) {
    if (i == v.size()) {
      ans = min(ans, cnt);
      return;
    }
    if (cnt >= ans) {
      return;
    }
    int x = v[i] / 3;
    int y = v[i] % 3;
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        if (grid[j][k] > 1) {
          int len = abs(j - x) + abs(k - y);
          grid[j][k]--;
          dfs(v, cnt + len, i + 1, grid);
          grid[j][k]++;
        }
      }
    }
  }
};