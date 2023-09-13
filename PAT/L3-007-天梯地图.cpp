#include <bits/stdc++.h>

using namespace std;

const int N = 510;
int n, m, S, T;
int d1[N][N], dist1[N];          // time
int d2[N][N], dist2[N], sum[N];  // distance
bool st[N];
int pre1[N], pre2[N];
vector<int> pathD, pathT;
void dijkstra1() {
  memset(dist1, 0x3f, sizeof dist1);
  memset(dist2, 0x3f, sizeof dist2);
  dist1[S] = 0, dist2[S] = 0;

  for (int i = 0; i < n - 1; i++) {
    int t = -1;
    for (int j = 0; j < n; j++)
      if (!st[j] && (t == -1 || dist1[j] < dist1[t]))
        t = j;
    st[t] = true;
    for (int j = 0; j < n; j++) {
      if (dist1[j] > dist1[t] + d1[t][j]) {
        dist1[j] = dist1[t] + d1[t][j];
        dist2[j] = dist2[t] + d2[t][j];
        pre1[j] = t;
      } else if (dist1[j] == dist1[t] + d1[t][j]) {
        if (dist2[j] > dist2[t] + d2[t][j]) {
          dist2[j] = dist2[t] + d2[t][j];
          pre1[j] = t;
        }
      }
    }
  }

  for (int i = T; i != S; i = pre1[i])
    pathT.push_back(i);
}

void dijkstra2() {
  memset(dist2, 0x3f, sizeof dist2);
  memset(st, false, sizeof st);
  dist2[S] = 0, sum[S] = 1;

  for (int i = 0; i < n - 1; i++) {
    int t = -1;
    for (int j = 0; j < n; j++)
      if (!st[j] && (t == -1 || dist2[j] < dist2[t]))
        t = j;
    st[t] = true;
    for (int j = 0; j < n; j++) {
      if (dist2[j] > dist2[t] + d2[t][j]) {
        dist2[j] = dist2[t] + d2[t][j];
        pre2[j] = t;
        sum[j] = sum[t] + 1;
      } else if (dist2[j] == dist2[t] + d2[t][j]) {
        if (sum[j] > sum[t] + 1) {
          sum[j] = sum[t] + 1;
          pre2[j] = t;
        }
      }
    }
  }

  for (int i = T; i != S; i = pre2[i])
    pathD.push_back(i);
}

int main() {
  memset(d1, 0x3f, sizeof d1);
  memset(d2, 0x3f, sizeof d2);

  cin >> n >> m;
  while (m--) {
    int a, b, isOnly, l, t;
    cin >> a >> b >> isOnly >> l >> t;
    d1[a][b] = t;
    d2[a][b] = l;
    if (!isOnly)
      d1[b][a] = t, d2[b][a] = l;
  }
  cin >> S >> T;

  dijkstra1();
  dijkstra2();

  if (pathD == pathT) {
    printf("Time = %d; Distance = %d: ", dist1[T], dist2[T]);
    cout << S;
    for (int i = pathD.size() - 1; i >= 0; i--)
      cout << " => " << pathD[i];
    cout << endl;
  } else {
    printf("Time = %d: ", dist1[T]);
    cout << S;
    for (int i = pathT.size() - 1; i >= 0; i--)
      cout << " => " << pathT[i];
    cout << endl;
    printf("Distance = %d: ", dist2[T]);
    cout << S;
    for (int i = pathD.size() - 1; i >= 0; i--)
      cout << " => " << pathD[i];
    cout << endl;
  }
}
