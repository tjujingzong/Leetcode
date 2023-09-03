#include <bits/stdc++.h>
using namespace std;

struct tim {
  int h, m, s;
};

bool operator<(const tim& a,
               const tim& b) {  // Corrected the return type to bool
  if (a.h != b.h)
    return a.h < b.h;
  if (a.m != b.m)
    return a.m < b.m;
  return a.s < b.s;
}

int main() {
  int n;
  cin >> n;
  tim ans1 = {24, 60, 60};
  tim ans2 = {0, 0, 0};
  string s1, s2;
  while (n-- > 0) {
    string id, in, out;
    cin >> id >> in >> out;
    tim t1 = {stoi(in.substr(0, 2)), stoi(in.substr(3, 2)),
               stoi(in.substr(6, 2))};
    tim t2 = {stoi(out.substr(0, 2)), stoi(out.substr(3, 2)),
               stoi(out.substr(6, 2))};
    if (t1 < ans1) {
      ans1 = t1;
      s1 = id;
    }

    if (ans2 < t2) {
      ans2 = t2;
      s2 = id;
    }
  }
  cout << s1 << " " << s2;
}
