#include <bits/stdc++.h>
using namespace std;

struct node {
  string id;
  int data;
  string next;
};

int main() {
  string start;
  int n, k;
  cin >> start >> n >> k;
  string t = start;
  unordered_map<string, node> ump;
  for (int i = 0; i < n; i++) {
    node a;
    cin >> a.id >> a.data >> a.next;
    ump[a.id] = a;
  }
  vector<node> v;
  while (t != "-1") {
    v.push_back(ump[t]);
    t = ump[t].next;
  }
  bool first = true;
  string last;
  string newstart;
  for (node& nd : v) {
    if (nd.data < 0)
      if (first) {
        last = nd.id;
        newstart = last;
        first = false;
      } else {
        ump[last].next = nd.id;
        last = nd.id;
      }
  }
  for (node& nd : v) {
    if (nd.data >= 0 && nd.data <= k) {
      if (first) {
        last = nd.id;
        newstart = last;
        first = false;
      } else {
        ump[last].next = nd.id;
        last = nd.id;
      }
    }
  }
  for (node& nd : v) {
    if (nd.data > k) {
      if (first) {
        last = nd.id;
        newstart = last;
        first = false;
      } else {
        ump[last].next = nd.id;
        last = nd.id;
      }
    }
  }
  ump[last].next = "-1";
  while (newstart != "-1") {
    cout << ump[newstart].id << " " << ump[newstart].data << " "
         << ump[newstart].next << endl;
    newstart = ump[newstart].next;
  }
}