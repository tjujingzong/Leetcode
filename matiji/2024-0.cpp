#include <bits/stdc++.h>

using namespace std;

int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int ans = 1;
  int left = 0, right = 1;
  map<int, int> m;
  m[a[0]] = 0;
  while (right < n) {
    m[a[right]] = right;
    if (m.find(a[right]) != m.end() && m[a[right]] >= left) {
      left = m[a[right]] + 1;
    } else {
      right++;
    }

    if (left == right) {
      right++;
    }
    cout << left << " " << right << endl;
    ans = max(ans, right - left);
  }
  cout << ans << endl;
  return 0;
}
// #include <bits/stdc++.h>

// using namespace std;
// struct flower {
//   string name;
//   int price;
//   int lastmodif;
// };

// int main() {
//   int n;
//   cin >> n;
//   int min = INT_MAX;
//   string mins = "";
//   map<string, flower> m;
//   while (n--) {
//     string s;
//     cin >> s;
//     if (m.find(s) == m.end()) {
//       flower f;
//       f.name = s;
//       f.price = 1000;
//       f.lastmodif = n;
//       m[s] = f;
//     }
//     int num;
//     cin >> num;
//     m[s].price += num;
//     m[s].lastmodif = n;
//   }
//   for (auto i : m) {
//     if (i.second.price < min) {
//       min = i.second.price;
//       mins = i.first;
//     }
//     if (i.second.price == min && i.second.lastmodif > m[mins].lastmodif) {
//       mins = i.first;
//     }
//   }
//   cout << mins << endl;
//   cout << min << endl;
//   return 0;
// }

// // #include <bits/stdc++.h>

// // using namespace std;

// // int main() {
// //   int n;
// //   cin >> n;
// //   while (n--) {
// //     string s;
// //     cin >> s;
// //     int t1 = 0, t2 = 0;  // t1 BABAB
// //     for (int i = 0; i < s.size(); i++) {
// //       if (i % 2 == 0) {
// //         if (s[i] == 'A')
// //           t1++;
// //         else
// //           t2++;
// //       } else {
// //         if (s[i] == 'B')
// //           t1++;
// //         else
// //           t2++;
// //       }
// //     }
// //     cout << t1 << " " << t2 << endl;
// //     cout << min(t1, t2) << endl;
// //   }

// //   return 0;
// // }
// // // #include <bits/stdc++.h>

// // // using namespace std;

// // // int main() {
// // //   int a, b;
// // //   cin >> a >> b;
// // //   cout << a + b << endl;
// // //   return 0;
// // // }
// // // #include <bits/stdc++.h>

// // // using namespace std;

// // // int main() {
// // //   string s;
// // //   cin >> s;
// // //   char c = 'A';
// // //   for (int i = 0; i < s.size(); i++) {
// // //     c = max(c, s[i]);
// // //   }
// // //   cout << c << endl;
// // //   return 0;
// // // }

// // // #include <bits/stdc++.h>

// // // using namespace std;

// // // int main() {
// // //   int n, m;
// // //   scanf("%d,%d", &n, &m);
// // //   int ans = 0;
// // //   for (int i = n; i <= m; i++) {
// // //     if (i % 6 == 0) {
// // //       ans += i;
// // //     }
// // //   }
// // //   printf("%d", ans);
// // //   return 0;
// // // }