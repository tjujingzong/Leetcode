#include <bits/stdc++.h>
using namespace std;

int dis[1030][1030];
int n, m, k, d;
bool vis[1030];
void dijistra(int pos) {
  memset(vis, 0, sizeof(vis));
  vis[pos] = true;
  while (1) {
    int minindex = -1;
    int minlen = 0x3f3f3f3f;
    for (int i = 1; i <= n; i++) {
      if (dis[pos][i] < minlen && !vis[i]) {
        minindex = i;
        minlen = dis[pos][i];
      }
    }
    for (int i = 1011; i <= 1010 + m; i++) {
      if (dis[pos][i] < minlen && !vis[i]) {
        minindex = i;
        minlen = dis[pos][i];
      }
    }
    if (minindex == -1)
      break;
    vis[minindex] = true;
    for (int i = 1; i <= n; i++) {
      if (vis[i])
        continue;
      if (dis[pos][i] > dis[pos][minindex] + dis[minindex][i]) {
        dis[pos][i] = dis[pos][minindex] + dis[minindex][i];
      }
    }
    for (int i = 1011; i <= 1010 + m; i++) {
      if (vis[i])
        continue;
      if (dis[pos][i] > dis[pos][minindex] + dis[minindex][i]) {
        dis[pos][i] = dis[pos][minindex] + dis[minindex][i];
      }
    }
  }
}
int main() {
  memset(dis, 0x3f, sizeof(dis));
  cin >> n >> m >> k >> d;
  while (k--) {
    string a, b;
    int di;
    int na, nb;
    cin >> a >> b >> di;
    if (a[0] == 'G') {
      na = 1010 + stoi(a.substr(1));
    } else
      na = stoi(a);
    if (b[0] == 'G') {
      nb = 1010 + stoi(b.substr(1));
    } else
      nb = stoi(b);
    dis[na][nb] = di;
    dis[nb][na] = di;
  }

  for (int i = 1011; i <= 1010 + m; i++) {
    dijistra(i);
  }
  int sum = d * n;
  int minn = 0;
  int ans = 1400;
  for (int i = 1011; i <= 1010 + m; i++) {
    int tsum = 0;
    int tmin = d;
    bool flag = true;
    for (int j = 1; j <= n; j++) {
      if (dis[i][j] > d) {
        flag = false;
        break;
      } else {
        tsum += dis[i][j];
        tmin = min(dis[i][j], tmin);
      }
    }
    if (flag && tmin > minn) {
      sum = tsum;
      ans = i;
      minn = tmin;
      continue;
    }
    if (flag && tmin == minn) {
      if (tsum < sum) {
        sum = tsum;
        ans = i;
        minn = tmin;
      }
    }
  }
  if (ans == 1400) {
    cout << "No Solution";
    return 0;
  }
  double avg = sum / (n * 1.0);
  double rounded_avg = round(avg * 10.0) / 10.0;
  printf("G%d\n%.1f %.1f", ans - 1010, (double)minn, rounded_avg);
}
