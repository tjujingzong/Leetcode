#include <iostream>
#include <string.h>
using namespace std;
int ans = 0;

void dfs(string s, int n, int i)
{
  if (s.size() >= n)
  {
    for (int j = 0; j < n; j++)
      if (s[j] == '1')
        ans++;
    cout << s;
    return;
  }
  int times = s[i] - '0';
  char add = '1';
  if (s[s.size() - 1] == '1')
    add = '2';
  for (int j = 0; j < times; j++)
  {
    s += add;
  }
  dfs(s, n, i + 1);
}
int magicalString(int n)
{
  string s = "122";
  dfs(s, n, 2);
  return ans;
}
int main()
{
  magicalString(20000);
  cout<<ans;
}