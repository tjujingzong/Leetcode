#include <bits/stdc++.h>
using namespace std;
struct node {
  int x, y;
};
vector getlen(vector<node>& v1, vector<node>& v2) {
  vector<int> ans;
  for (int i = 0; i < v1.size(); i++) {
    int n1 = v1[i];
    int n2 = v1[(i + 1) % v1.size()];
    ans.push_back((n1.x - n2.x) * (n1.x - n2.x) +
                  (n1.y - n2.y) * (n1.y - n2.y));
  }
  return ans;
}
bool check_quadrilateral(vector<node>& v1, vector<node>& v2) {
  int l1 = gethypotenuse(v1);
  int l2 = gethypotenuse(v2);
  if (l1 != l2) {
    return false;
  }
  vector<int> len1 = getlen(v1);
  vector<int> len2 = getlen(v2);
  if (l1 == 0 && l2 == 0) {
    for (int i : len1) {
      for (int j : len2) {
        if (i == j) {
          return true;
        }
      }
    }
  }
  if (l1 == l2) {
    int oppl1 = -1;
    int oppl2 = -2;
    for (int i = 0; i < len1.size(); i++) {
      if (len1[i] == l1) {
        oppl1 = len1[(i + 2) % len1.size()];
      }
    }
    for (int i = 0; i < len2.size(); i++) {
      if (len2[i] == l2) {
        oppl2 = len2[(i + 2) % len2.size()];
      }
    }
    return oppl1 == oppl2;
  }
  return false;
}

int gethypotenuse(vector<node>& v) {
  int cnt = 0;
  int ans = -1;
  for (int i = 0; i < v.size(); i++) {
    int n1 = v[i];
    int n2 = v[(i + 1) % v.size()];
    if (n1.x == n2.x || n1.y == n2.y)
      continue;
    cnt++;
    ans = (n1.x - n2.x) * (n1.x - n2.x) + (n1.y - n2.y) * (n1.y - n2.y);
  }
  if (cnt == 0)
    return 0;
  if (cnt == 1)
    return ans;
  return -1;
}
int main() {
  int kase;
  cin >> kase;
  while (kase--) {
    int k1;
    cin >> k1;
    vector<node> v1(k1);
    for (int i = 0; i < k1; i++)
      cin >> v1[i].x >> v1[i].y;
    int k2;
    cin >> k2;
    vector<node> v2(k2);
    for (int i = 0; i < k2; i++)
      cin >> v2[i].x >> v2[i].y;
    if (k1 == 3 || k2 == 3) {
      int l1 = gethypotenuse(v1);
      int l2 = gethypotenuse(v2);
      if (l1 > 0 && l1 == l2)
        cout << "YES" << endl;
      else
        cout << "NO" << endl;
      continue;
    }
    if (k1 == 4 && k2 == 4) {
      if (check_quadrilateral(v1, v2)) {
        cout << "YES" << endl;
      } else {
        cout << "NO" << endl;
      }
      continue;
    }
    cout << "NO" << endl;
  }
}
