using PII = pair<int, int>;
vector<PII> dir4{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
PII operator+(PII a, PII b) {
  return {a.first + b.first, a.second + b.second};
}

class Solution {
 public:
  int maximumSafenessFactor(vector<vector<int>>& grid) {
    int n = grid.size();
    vector<vector<int>> dis(n, vector<int>(n, INT_MAX));

    queue<pair<int, int>> q;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j]) {
          q.push({i, j});
          dis[i][j] = 0;
        }
      }
    }

    while (!q.empty()) {
      auto [i, j] = q.front();
      q.pop();

      for (auto& d : dir4) {
        auto [x, y] = d + make_pair(i, j);
        if (x >= 0 && x < n && y >= 0 && y < n) {
          if (dis[x][y] < INT_MAX)
            continue;
          dis[x][y] = dis[i][j] + 1;
          q.push({x, y});
        }
      }
    }

    priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>,
                   less<tuple<int, int, int>>>
        pq;
    pq.push({dis[0][0], 0, 0});
    vector<vector<bool>> v(n, vector<bool>(n));

    int ans = INT_MAX;
    while (!pq.empty()) {
      auto [di, i, j] = pq.top();
      pq.pop();
      if (v[i][j])
        continue;

      v[i][j] = true;
      ans = min(ans, di);
      if (i == n - 1 && j == n - 1)
        return ans;

      for (auto& d : dir4) {
        auto [x, y] = d + make_pair(i, j);
        if (x >= 0 && x < n && y >= 0 && y < n) {
          if (v[x][y])
            continue;
          pq.push({dis[x][y], x, y});
        }
      }
    }

    return 0;
  }
};
