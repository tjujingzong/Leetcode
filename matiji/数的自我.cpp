#include <bits/stdc++.h>
int self_flag[10000007];
int self[10000007];

using namespace std;
int selfNumber(int num) {
  int result = num;
  while (num > 0) {
    result += num % 10;
    num /= 10;
  }
  return result;
}

int main() {
  int n, k;
  cin >> n >> k;
  memset(self_flag, false, sizeof(self_flag));
  int counts = 0;
  for (int i = 1; i <= n; i++) {
    int result = selfNumber(i);
    if (result <= n) {
      self_flag[result] = true;
    }
    if (!self_flag[i]) {
      self[counts++] = i;
    }
  }
  cout << counts << endl;
  for (int i = 0; i < k; i++) {
    int idx;
    cin >> idx;
    cout << self[idx - 1] << " ";
  }
  return 0;
}