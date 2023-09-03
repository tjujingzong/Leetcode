#include <bits/stdc++.h>
using namespace std;
int n, ka, kb, ha, hb;
bool flag;
vector<int> ea, eb;
vector<bool> aa, ab;
vector<int> calEdge(vector<pair<int, int>> v) {
  vector<int> e;
  for (int i = 0; i < v.size(); ++i) {
    int Right = i == v.size() - 1 ? 0 : i + 1;
    e.push_back(sqrt(
        (v[i].first - v[Right].first) * (v[i].first - v[Right].first) +
        (v[i].second - v[Right].second) * (v[i].second - v[Right].second)));
  }
  return e;
}
vector<bool> calAngel(vector<pair<int, int>> v) {
  vector<bool> angel;
  for (int i = 0; i < v.size(); ++i) {
    int Left = i == 0 ? v.size() - 1 : i - 1,
        Right = i == v.size() - 1 ? 0 : i + 1;
    angel.push_back(
        (v[Left].first == v[i].first && v[i].second == v[Right].second) ||
        (v[Left].second == v[i].second && v[i].first == v[Right].first));
  }
  return angel;
}
int getHypotenuse(vector<bool> angel) {
  int ans = -2, cnt = 0;
  for (int i = 0; i < angel.size(); ++i) {
    int Left = i == 0 ? angel.size() - 1 : i - 1;
    if (angel[i])
      ++cnt;
    else if (angel[Left])
      ans = i;
  }
  return cnt >= (angel.size() - 2) ? ans : -1;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    flag = false;
    scanf("%d", &ka);
    vector<pair<int, int>> pointa(ka);
    for (int j = 0; j < ka; ++j)
      scanf("%d %d", &pointa[j].first, &pointa[j].second);
    scanf("%d", &kb);
    vector<pair<int, int>> pointb(kb);
    for (int j = 0; j < kb; ++j)
      scanf("%d %d", &pointb[j].first, &pointb[j].second);
    if (ka > kb)
      swap(pointa, pointb);
    ea = calEdge(pointa), eb = calEdge(pointb);
    aa = calAngel(pointa), ab = calAngel(pointb);
    ha = getHypotenuse(aa), hb = getHypotenuse(ab);
    if (ha == -1 || hb == -1)
      ;
    else if (ka == 3 && kb == 3) {
      sort(ea.begin(), ea.end()), sort(eb.begin(), eb.end());
      if (ea == eb)
        flag = true;
    } else if (ka == 4 && kb == 4) {
      if (ha == -2 || hb == -2) {
        if (ha == -2 && hb == -2 &&
            (ea[0] == eb[0] || ea[0] == eb[1] || ea[1] == eb[1] ||
             ea[1] == eb[0]))
          flag = true;
      } else if (ea[ha] == eb[hb] && ea[(ha + 2) % 4] == eb[(hb + 2) % 4] &&
                 (((ea[(ha + 1) % 4] + eb[(hb + 1) % 4]) ==
                   (ea[(ha + 3) % 4] + eb[(hb + 3) % 4])) ||
                  ((ea[(ha + 1) % 4] + eb[(hb + 3) % 4]) ==
                   (ea[(ha + 3) % 4] + eb[(hb + 1) % 4]))))
        flag = true;
    } else if ((ka == 3 && kb == 4) || (ka == 4 && kb == 3)) {
      if (ea[ha] == eb[hb] &&
              (ea[(ha + 2) % 3] == eb[(hb + 2) % 4] &&
               (ea[(ha + 1) % 3] + min(eb[(hb + 1) % 4], eb[(hb + 3) % 4]) ==
                max(eb[(hb + 1) % 4], eb[(hb + 3) % 4]))) ||
          (ea[(ha + 1) % 3] == eb[(hb + 2) % 4] &&
           (ea[(ha + 2) % 3] + min(eb[(hb + 1) % 4], eb[(hb + 3) % 4]) ==
            max(eb[(hb + 1) % 4], eb[(hb + 3) % 4]))))
        flag = true;
    } else if ((ka == 3 && kb == 5) || (ka == 5 && kb == 3)) {
      if (ea[ha] == eb[hb] &&
          (((ea[(ha + 2) % 3] + min(eb[(hb + 2) % 5], eb[(hb + 4) % 5]) ==
             max(eb[(hb + 2) % 5], eb[(hb + 4) % 5])) &&
            (ea[(ha + 1) % 3] + min(eb[(hb + 1) % 5], eb[(hb + 3) % 5]) ==
             max(eb[(hb + 1) % 5], eb[(hb + 3) % 5]))) ||
           ((ea[(ha + 1) % 3] + min(eb[(hb + 2) % 5], eb[(hb + 4) % 5]) ==
             max(eb[(hb + 2) % 5], eb[(hb + 4) % 5])) &&
            (ea[(ha + 2) % 3] + min(eb[(hb + 1) % 5], eb[(hb + 3) % 5]) ==
             max(eb[(hb + 1) % 5], eb[(hb + 3) % 5])))))
        flag = true;
    }
    printf("%s\n", flag ? "YES" : "NO");
  }
}