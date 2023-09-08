#include <bits/stdc++.h>
using namespace std;
vector<int> a[1005];
int dis[1005][1005];
int n;

bool isdijistra(int arr[]) {
  for (int i = 3; i <= n; i++) {
    if (dis[arr[1]][arr[i]] < dis[arr[1]][arr[i - 1]])
      return false;
  }
  return true;
}

int main() {
  cin >> n;
  memset(dis, 0x3f, sizeof(dis));
  int m;
  cin >> m;
  while (m--) {
    int x, y, d;
    scanf("%d %d %d", &x, &y, &d);
    a[x].push_back(y);
    a[y].push_back(x);
    dis[x][y] = d;
    dis[y][x] = d;
  }
  bool isvis[n + 1];
  memset(isvis, false, sizeof(isvis));
  for (int i = 1; i <= n; i++) {
    dis[i][i] = 0;
  }
  for (int i = 1; i <= n; i++) {
    memset(isvis, false, sizeof(isvis));
    isvis[i] = true;
    for (int j = 1; j <= n; j++) {
      int minn = 0x3f3f3f3f, pos = 0;
      for (int k = 1; k <= n; k++) {
        if (!isvis[k] && dis[i][k] < minn) {
          minn = dis[i][k];
          pos = k;
        }
      }
      isvis[pos] = true;
      for (int k = 0; k < a[pos].size(); k++) {
        int v = a[pos][k];
        if (dis[i][v] > dis[i][pos] + dis[pos][v]) {
          dis[i][v] = dis[i][pos] + dis[pos][v];
        }
      }
    }
  }
  // for (int i = 1; i <= n; i++) {
  //   for (int j = 1; j <= n; j++) {
  //     cout << dis[i][j] << " ";
  //   }
  //   cout << endl;
  // }

  int k;
  cin >> k;
  while (k--) {
    int arr[n + 1];
    for (int i = 1; i <= n; i++) {
      scanf("%d", &arr[i]);
    }
    if (isdijistra(arr)) {
      cout << "Yes" << endl;
    } else {
      cout << "No" << endl;
    }
  }
}