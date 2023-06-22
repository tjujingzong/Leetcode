class Solution {
 public:
  int direction[8][2] = {{0, 1}, {0, -1}, {1, 0},   {-1, 0},
                         {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
  vector<int> pondSizes(vector<vector<int>>& land) {
    int n = land.size();
    int m = land[0].size();
    vector<int> ans;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (land[i][j] == 0) {
          ans.push_back(bfs(land, i, j));
        }
      }
    }
    sort(ans.begin(), ans.end());
    return ans;
  }
  int bfs(vector<vector<int>>& land, int x, int y) {
    int n = land.size();
    int m = land[0].size();
    queue<pair<int, int>> q;
    q.push({x, y});
    land[x][y] = -1;
    int ans = 1;
    while (!q.empty()) {
      auto [x, y] = q.front();
      q.pop();
      for (int i = 0; i < 8; ++i) {
        int nx = x + direction[i][0];
        int ny = y + direction[i][1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 0) {
          q.push({nx, ny});
          land[nx][ny] = -1;
          ++ans;
        }
      }
    }
    return ans;
  }
};