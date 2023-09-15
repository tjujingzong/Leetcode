#include <bits/stdc++.h>
using namespace std;
int fa[10005];
int find(int x) {
  while (x != fa[x]) {
    fa[x] = fa[fa[x]];
    x = fa[x];
  }
  return x;
}
void merge(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  fa[fx] = fy;
}

struct pers {
  int id;
  int ma, fa;
  vector<int> c;
  int n_est;
  int area;
};

struct family {
  vector<int> v;
  int min_id = 10000;
  double avg_est;
  double avg_area;
  int father;
};

int main() {
  int n;
  cin >> n;
  unordered_map<int, pers> mp;
  set<int> s;
  for (int i = 0; i < 10005; i++) {
    fa[i] = i;
  }
  while (n--) {
    pers p;
    int k;
    cin >> p.id >> p.fa >> p.ma;
    cin >> k;
    s.insert(p.id);
    if (p.fa != -1)
      s.insert(p.fa);
    if (p.ma != -1)
      s.insert(p.ma);
    while (k--) {
      int child;
      cin >> child;
      p.c.push_back(child);
      s.insert(child);
    }
    cin >> p.n_est >> p.area;
    mp[p.id] = p;
  }
  for (auto& it : mp) {
    int p = it.first;
    pers pp = it.second;
    if (pp.fa != -1)
      merge(p, pp.fa);
    if (pp.ma != -1)
      merge(p, pp.ma);
    for (int& cc : pp.c) {
      merge(p, cc);
    }
  }
  vector<family> vf;
  for (const int& p : s) {
    bool addnew = true;
    for (family& f : vf) {
      if (find(f.v.begin(), f.v.end(), p) != f.v.end()) {
        addnew = false;
        break;
      } else if (f.father == find(p)) {
        f.v.push_back(p);
        addnew = false;
        break;
      }
    }
    if (addnew) {
      family nf;
      nf.father = find(p);
      nf.v.push_back(p);
      vf.push_back(nf);
    }
  }
  for (family& f : vf) {
    int sum1 = 0, sum2 = 0;
    for (int& p : f.v) {
      f.min_id = min(f.min_id, p);
      sum1 += mp[p].n_est;
      sum2 += mp[p].area;
    }
    f.avg_est = (double)sum1 / f.v.size();
    f.avg_area = (double)sum2 / f.v.size();
  }
  sort(vf.begin(), vf.end(), [](const family& a, const family& b) {
    if (a.avg_area == b.avg_area) {
      return a.min_id < b.min_id;
    }
    return a.avg_area > b.avg_area;
  });
  cout << vf.size() << endl;

  for (family& f : vf) {
    printf("%04d %d %.3f %.3f\n", f.min_id, (int)f.v.size(), f.avg_est,
           f.avg_area);
  }
}