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
struct st {
  int id;
  int score;
};

struct sch {
  int father;
  vector<st> v;
  int total = 0;
};

int main() {
  for (int i = 0; i < 10005; i++) {
    fa[i] = i;
  }
  int n;
  cin >> n;
  unordered_map<int, st> smp;
  for (int i = 0; i < n; i++) {
    int idd, k, sc;
    cin >> idd >> k;
    for (int j = 0; j < k; j++) {
      int t;
      cin >> t;
      merge(idd, t);
      if (smp.find(t) == smp.end()) {
        smp[t] = {t, 0};
      }
    }
    cin >> sc;
    smp[idd] = {idd, sc};
  }
  vector<sch> sv;
  for (auto& p : smp) {
    st pst = p.second;
    int pf = find(pst.id);
    bool addone = true;
    for (sch& schh : sv) {
      if (schh.father == pf) {
        schh.v.push_back(pst);
        addone = false;
        break;
      }
    }
    if (addone) {
      sch schh;
      schh.father = pf;
      schh.v.push_back(pst);
      sv.push_back(schh);
    }
  }
  for (sch& schh : sv) {
    for (st& stt : schh.v) {
      schh.total += stt.score;
    }
    sort(schh.v.begin(), schh.v.end(),
         [](st& a, st& b) { return a.id < b.id; });
  }
  sort(sv.begin(), sv.end(), [](sch& a, sch& b) {
    if (a.total == b.total) {
      if (a.v.size() == b.v.size()) {
        return a.v[0].id < b.v[0].id;
      }
      return a.v.size() < b.v.size();
    }
    return a.total > b.total;
  });
  cout << sv.size() << endl;
  for (sch& schh : sv) {
    printf("%04d", schh.v[0].id);
    cout << " " << schh.v.size() << " " << schh.total << endl;
  }
  return 0;
}