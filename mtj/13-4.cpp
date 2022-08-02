#include <bits/stdc++.h>
using namespace std;
const int N = 3005;

int f[N][N][2], n, c;
int pos[N], w[N], sum[N];

int main()
{
  scanf("%d %d", &n, &c);
  for (int i = 1; i <= n; ++i)
    scanf("%d %d", pos + i, w + i), sum[i] = sum[i - 1] + w[i]; //记录前缀和
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      f[i][j][1] = f[i][j][0] = 270000000; //初始化
  f[c][c][0] = f[c][c][1] = 0;
  for (int len = 2; len <= n; ++len)
  {
    for (int i = 1; i <= n - len + 1; ++i)
    {
      int j = i + len - 1;
      f[i][j][1] = min(f[i + 1][j][1] + (pos[i + 1] - pos[i]) * (sum[n] - sum[j] + sum[i]), f[i + 1][j][0] + (pos[j] - pos[i]) * (sum[n] - sum[j] + sum[i]));
      f[i][j][0] = min(f[i][j - 1][0] + (pos[j] - pos[j - 1]) * (sum[i - 1] + sum[n] - sum[j - 1]), f[i][j - 1][1] + (pos[j] - pos[i]) * (sum[i - 1] + sum[n] - sum[j - 1]));
    }
  }
  printf("%d", min(f[1][n][1], f[1][n][0]));
  return 0;
}