#include <bits/stdc++.h>
using namespace std;
struct stu {
  string type;
  string test;
  string date;
  string testnum;
  int score;
  string all;
};

struct dayy {
  string test;
  int cnt;
};
bool cmp(dayy a, dayy b) {
  if (a.cnt != b.cnt)
    return a.cnt > b.cnt;
  else
    return a.test < b.test;
}
bool cmp2(stu a, stu b) {
  if (a.score != b.score)
    return a.score > b.score;
  else
    return a.all < b.all;
}
int main() {
  int n, m;
  cin >> n >> m;
  vector<stu> v(n);
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    v[i].all = s;
    v[i].type = s.substr(0, 1);
    v[i].test = s.substr(1, 3);
    v[i].date = s.substr(4, 6);
    v[i].testnum = s.substr(10, 3);
    cin >> v[i].score;
  }
  for (int i = 1; i <= m; i++) {
    int q1;
    string q2;
    cin >> q1 >> q2;
    printf("Case %d: %d %s\n", i, q1, q2.c_str());
    sort(v.begin(), v.end(), cmp2);
    if (q1 == 1) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (v[j].type == q2) {
          cout << v[j].all << " " << v[j].score << endl;
          cnt++;
        }
      }
      if (cnt == 0) {
        cout << "NA" << endl;
      }
    } else if (q1 == 2) {
      int cnt = 0;
      int summ = 0;
      for (int j = 0; j < n; j++) {
        if (v[j].test == q2) {
          cnt++;
          summ += v[j].score;
        }
      }
      if (cnt == 0) {
        cout << "NA" << endl;
      } else
        printf("%d %d\n", cnt, summ);
    } else if (q1 == 3) {
      unordered_map<string, int> mp;
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (v[j].date == q2) {
          mp[v[j].test]++;
          cnt++;
        }
      }
      dayy d[mp.size()];
      int k = 0;
      for (auto it : mp) {
        d[k].test = it.first;
        d[k].cnt = it.second;
        k++;
      }
      sort(d, d + mp.size(), cmp);
      if (cnt == 0) {
        cout << "NA" << endl;
      }
      for (int i = 0; i < mp.size(); i++) {
        printf("%s %d\n", d[i].test.c_str(), d[i].cnt);
      }
    }
  }
}