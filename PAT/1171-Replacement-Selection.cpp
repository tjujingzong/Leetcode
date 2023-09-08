#include <bits/stdc++.h>
using namespace std;
struct num {
  int val;
  int index;
};
bool operator<(const num& a, const num& b) {
  if (a.index == b.index)
    return a.val < b.val;
  return a.index < b.index;
}
int main() {
  int n, m;
  cin >> n >> m;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  vector<num> nums;
  vector<priority_queue<int, vector<int>, greater<int>>> v;
  priority_queue<int, vector<int>, greater<int>> pq0;
  v.push_back(pq0);
  for (int i = 0; i < m; i++) {
    v[0].push(a[i]);
    nums.push_back({a[i], 0});
  }
  for (int i = m; i < n; i++) {
    bool flag = false;
    for (int j = 0; j < v.size(); j++) {
      if (a[i] > v[j].top()) {
        v[j].push(a[i]);
        flag = true;
        if (v[j].size() > m) {
          v[j].pop();
        }
        nums.push_back({a[i], j});
        break;
      }
    }
    if (!flag) {
      priority_queue<int, vector<int>, greater<int>> pq;
      pq.push(a[i]);
      v.push_back(pq);
      nums.push_back({a[i], v.size() - 1});
    }
  }
  sort(nums.begin(), nums.end());
  for (int i = 0; i < nums.size(); i++) {
    cout << nums[i].val;
    if (i + 1 < nums.size() && nums[i].index != nums[i + 1].index)
      cout << endl;
    else if (i + 1 != nums.size())
      cout << " ";
  }
}
