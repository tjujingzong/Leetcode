#include <bits/stdc++.h>

using namespace std;
int grid[2005][2005];
int ans[2005][2005];
int n;
struct pos {
  int x, y, step;
};

void bfs(int i, int j) {
  queue<pos> q;
  q.push({i, j, 0});
  while (!q.empty()) {
    pos cur = q.front();
    q.pop();
    cur.x = (cur.x + n) % n;
    cur.y = (cur.y + n) % n;
    if (cur.step >= ans[cur.x][cur.y])
      continue;
    if (grid[cur.x][cur.y] == 0)
      continue;
    ans[cur.x][cur.y] = min(cur.step, ans[cur.x][cur.y]);
    q.push({cur.x + 1, cur.y, cur.step + 1});
    q.push({cur.x - 1, cur.y, cur.step + 1});
    q.push({cur.x, cur.y + 1, cur.step + 1});
    q.push({cur.x, cur.y - 1, cur.step + 1});
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      scanf("%d", &grid[i][j]);
  memset(ans, 0x3f, sizeof(ans));
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (grid[i][j] == 2) {
        bfs(i, j);
      }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      printf("%d", ans[i][j] == 0x3f3f3f3f ? -1 : ans[i][j]);
      if (j == n - 1)
        printf("\n");
      else
        printf(" ");
    }

  return 0;
}