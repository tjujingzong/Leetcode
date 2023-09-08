#include <bits/stdc++.h>
using namespace std;
struct blok {
  string add;
  int data;
  string next;
};

int main() {
  string start;
  int n, k;
  cin >> start >> n >> k;
  unordered_map<string, blok> mm;
  blok m[n + 5];
  for (int i = 0; i < n; i++) {
    blok b;
    cin >> b.add >> b.data >> b.next;
    mm[b.add] = b;
  }
  int idx = 1;
  while (start != "-1") {
    m[idx] = mm[start];
    idx++;
    start = mm[start].next;
  }
  int newstartindex = n % k == 0 ? n - k + 1 : n / k * k + 1;
  string newstart = m[newstartindex].add;
  int t = n % k == 0 ? n - k : (n / k - 1) * k + 1;
  m[n].next = m[t].add;
  for (int i = 2; i * k <= n; i++) {
    m[i * k].next = m[(i - 2) * k + 1].add;
  }
  m[k].next = "-1";
  unordered_map<string, blok> mp;
  for (int i = 1; i <= n; i++) {
    mp[m[i].add] = m[i];
  }

  for (int i = 1; i <= n; i++) {
    cout << mp[newstart].add << " " << mp[newstart].data << " "
         << mp[newstart].next << endl;
    newstart = mp[newstart].next;
  }
}
