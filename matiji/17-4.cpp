#include <bits/stdc++.h>

using namespace std;
string head[26][10005];
int order[26][10005];
int cnt[26];
string s[10005];
int ans[10005];
int main()
{
  int n;
  cin >> n;
  memset(ans, 0, sizeof(ans));
  memset(order, 0, sizeof(order));
  memset(cnt, 0, sizeof(cnt));
  for (int i = 0; i < n; i++)
  {
    cin >> s[i];
    int p = s[i][0] - 'a';
    head[p][cnt[p]] = s[i];
    order[p][cnt[p]] = i;
    cnt[p]++;
  }
  string text;
  cin >> text;
  for (int i = 0; i < text.length(); i++)
  {
    int p = text[i] - 'a';
    for (int j = 0; j < cnt[p]; j++)
    {
      bool matched = true;
      for (int k = 0; k < head[p][j].length(); k++)
      {
        if (head[p][j][k] != text[i + k])
        {
          matched = false;
          break;
        }
      }
      if (matched)
      {
        int index = order[p][j];
        ans[index]++;
      }
    }
  }
  for (int i = 0; i < n; i++)
    cout << ans[i] << " ";
  return 0;
}