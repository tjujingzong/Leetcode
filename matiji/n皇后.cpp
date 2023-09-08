#include<bits/stdc++.h>
using namespace std;
class Solution
{
public:
  int ans = 0;
  bool visited[9];
  int totalNQueens(int n)
  {
    for (int i = 0; i < n; i++)
    {
      visited[i] = true;
      vector<int> v;
      v.push_back(i);
      dfs(i, n, v);
      visited[i] = false;
    }
    return ans;
  }
  void dfs(int pos, int n, vector<int> &v)
  {
    if (v.size() == n)
    {
      ans++;
      return;
    }
    for (int i = 0; i < n; i++)
    {
      if (visited[i])
        continue;
      bool flag = false;
      for (int j = 0; j < v.size(); j++)
      {
        if (abs(i - v[j]) == v.size() - j)
        {
          flag = true;
          break;
        }
      }
      if (flag)
        continue;
      vector<int> t(v);
      t.push_back(i);
      visited[i] = true;
      dfs(i, n, t);
      visited[i] = false;
    }
  }
};
int main(){
  Solution s;
  cout<<s.totalNQueens(4);
}
