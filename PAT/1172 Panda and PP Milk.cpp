#include <bits/stdc++.h>
using namespace std;
struct panda {
  int pos;
  int milk;
  int weight;
};

int main() {
  int n;
  cin >> n;
  panda pds[n];

  for (int i = 0; i < n; i++) {
    cin >> pds[i].weight;
    pds[i].pos = i;
    pds[i].milk = 200;
  }

  for (int i = 0; i < n - 1; i++) {
    if (pds[i].weight < pds[i + 1].weight) {
      pds[i + 1].milk = max(pds[i + 1].milk, pds[i].milk + 100);
    } else if (pds[i].weight == pds[i + 1].weight) {
      pds[i + 1].milk = max(pds[i + 1].milk, pds[i].milk);
    }
  }
  for (int i = n - 1; i > 0; i--) {
    if (pds[i].weight < pds[i - 1].weight) {
      pds[i - 1].milk = max(pds[i - 1].milk, pds[i].milk + 100);
    } else if (pds[i].weight == pds[i - 1].weight) {
      pds[i - 1].milk = max(pds[i - 1].milk, pds[i].milk);
    }
  }
  int sum = 0;
  for (int i = 0; i < n; i++) {
    sum += pds[i].milk;
  }
  cout << sum;
}