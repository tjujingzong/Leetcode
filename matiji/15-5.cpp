#include <bits/stdc++.h>

using namespace std;

int m, n;
int mapp[1005][1005];
int opt[1005][1005];
int colsum[1005][1005];
int main()
{
  memset(mapp, 0, sizeof(mapp));
  memset(opt, 0, sizeof(opt));
  memset(colsum, 0, sizeof(colsum));
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
    {
      scanf("%d", &mapp[i][j]);
      colsum[i][j] = colsum[i - 1][j] + mapp[i][j];
    }
  for (int i = 1; i <= n; i++)
    opt[i][1] = opt[i - 1][1] + mapp[i][1];
  for (int col = 2; col <= m; col++)
  {
    for (int row = 1; row <= n; row++)
    {
      for (int k = 1; k <= n; k++)
        if (k <= row)
          opt[row][col] = max(opt[row][col], opt[k][col - 1] + colsum[row][col] - colsum[k - 1][col]);
        else
          opt[row][col] = max(opt[row][col], opt[k][col - 1] + colsum[k][col] - colsum[row - 1][col]);
    }
  }
  cout << opt[n][m];
}