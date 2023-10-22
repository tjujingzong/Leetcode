#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

struct act {
  int tim;
  int val;
};
vector<act> acts;

int main() {
  int n, m, q;
  cin >> n >> m >> q;

  int a[q];
  for (int i = 0; i < q; i++) {
    cin >> a[i];
  }

  vector<int> days;
  if (a[0] > 1) {
    days.push_back(a[0] - 1);
  }

  for (int i = 1; i < q; i++) {
    days.push_back(a[i] - a[i - 1] - 1);
  }

  if (a[q - 1] < n) {
    days.push_back(n - a[q - 1]);
  }

  for (int i = 0; i < m; i++) {
    int t, v;
    cin >> t >> v;
    act a;
    a.tim = 1 << t;
    a.val = v;
    acts.push_back(a);
  }

  int ans = 0;
  sort(days.begin(), days.end());
  int maxday = days[days.size() - 1];
  vector<int> dp(maxday + 1, 0);
  for (int i = 0; i <= maxday; i++) {
    dp[i] = max(dp[i], dp[i - 1]);
    for (int j = 0; j < acts.size(); j++) {
      if (i + acts[j].tim <= maxday) {
        dp[i + acts[j].tim] = max(dp[i + acts[j].tim], dp[i] + acts[j].val);
      }
    }
  }

  for (int i = 0; i < days.size(); i++) {
    ans += dp[days[i]];
  }
  cout << ans << endl;
  return 0;
}