#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct SportEvent {
  int time;
  int rest;
};

bool compareByRest(const SportEvent& a, const SportEvent& b) {
  return a.time + a.rest < b.time + b.rest;
}

int main() {
  int n, k;
  cin >> n >> k;

  vector<SportEvent> events(n);
  for (int i = 0; i < n; ++i) {
    cin >> events[i].time;
  }
  for (int i = 0; i < n; ++i) {
    cin >> events[i].rest;
  }
  sort(events.begin(), events.end(), compareByRest);
  int ans = 0;
  while (1) {
    int t = events[0].time + events[0].rest;
    if (k >= t) {
      k -= t;
      ans++;
      events.erase(events.begin());
    } else {
      int t1 = events[0].time;
      for (int i = 1; i < events.size(); i++) {
        if (events[i].time <= t1) {
          t1 = events[i].time;
        }
      }
      if (k >= t1) {
        ans++;
      }
      break;
    }
  }
  cout << ans << endl;
}
