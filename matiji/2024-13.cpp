#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  long long n, ti, pi, cur_t = 1, res = 0;
  multiset<int> sum;
  map<long long, vector<long long>> ti_map;

  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> ti >> pi;
    ti_map[ti].push_back(pi);
  }

  for (auto iter = ti_map.begin(); iter != ti_map.end(); ++iter) {
    ti = iter->first;
    vector<long long> vec_pi = iter->second;
    sort(vec_pi.begin(), vec_pi.end());
    int i = vec_pi.size() - 1;
    while (i >= 0) {
      if (cur_t <= ti && i >= 0) {
        auto sum_iter = sum.begin();
        if (vec_pi[i] > *sum_iter) {
          sum.erase(sum_iter);
          sum.emplace(vec_pi[i]);
          --i;
          continue;
        }
      }
      if (ti < cur_t)
        break;
      sum.emplace(vec_pi[i]);
      ++cur_t;
      --i;
    }
  }

  for (auto s : sum) {
    res += s;
  }
  cout << res;
  return 0;
}

// #include <bits/stdc++.h>
// using namespace std;

// int main() {
//   int t;
//   scanf("%d", &t);
//   while (t--) {
//     int n;
//     scanf("%d", &n);
//     vector<pair<int, char>> items(n);
//     for (int i = 0; i < n; i++) {
//       scanf("%d", &items[i].first);
//     }
//     for (int i = 0; i < n; i++) {
//       scanf(" %c", &items[i].second);
//     }

//     // 将红色和蓝色分开，并按照不同的顺序排序
//     vector<int> red, blue;
//     for (auto& item : items) {
//       if (item.second == 'R')
//         red.push_back(item.first);
//       else
//         blue.push_back(item.first);
//     }
//     bool flag = true;
//     sort(red.rbegin(), red.rend());
//     sort(blue.begin(), blue.end());
//     for (int i = 1; i <= blue.size(); i++) {
//       if (blue[i-1] < i) {
//         printf("NO\n");
//         flag = false;
//         break;
//       }
//     }
//     if (!flag) {
//       continue;
//     }
//     for (int i = 1; i <= red.size(); i++) {
//       if (red[i-1] > n + 1 - i) {
//         printf("NO\n");
//         flag = false;
//         break;
//       }
//     }
//     if (!flag) {
//       continue;
//     }
//     printf("YES\n");
//   }
//   return 0;
// }
