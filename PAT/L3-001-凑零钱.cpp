#include <bits/stdc++.h>
using namespace std;
int n, m;
bool flag = false;
vector<int> coins;
void dfs(int sum, int index, vector<int>& ans) {
  if (sum == m) {
    flag = true;
    for (int i = 0; i < ans.size(); i++) {
      if (i != 0)
        cout << " ";
      cout << ans[i];
    }
    cout << endl;
    return;
  }
  if (flag || sum > m || index >= coins.size())
    return;
  ans.push_back(coins[index]);
  dfs(sum + coins[index], index + 1, ans);
  ans.pop_back();
  dfs(sum, index + 1, ans);
}
int main() {
  cin >> n >> m;
  int summ = 0;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    if (temp <= m) {
      coins.push_back(temp);
      summ += temp;
    }
  }
  if (summ < m) {//特殊用例
    cout << "No Solution" << endl;
    return 0;
  }
  sort(coins.begin(), coins.end());
  vector<int> ans;
  dfs(0, 0, ans);
  if (!flag)
    cout << "No Solution" << endl;
}