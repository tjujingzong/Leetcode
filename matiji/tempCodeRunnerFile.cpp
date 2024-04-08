#include <bits/stdc++.h>

using namespace std;

int main() {
  int n;
  cin >> n;
  while (n--) {
    string s;
    cin >> s;
    int t1 = 0, t2 = 0;
    for (int i = 0; i < s.size(); i++) {
      if (i % 2 == 0) {
        if (s[i] == 'A')
          t1++;
        else
          t2++;
      } else {
        if (s[i] == 'B')
          t2++;
        else
          t1++;
      }
      cout << min(t1, t2) << endl;
    }
  }

  return 0;
}
// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//   int a, b;
//   cin >> a >> b;
//   cout << a + b << endl;
//   return 0;
// }
// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//   string s;
//   cin >> s;
//   char c = 'A';
//   for (int i = 0; i < s.size(); i++) {
//     c = max(c, s[i]);
//   }
//   cout << c << endl;
//   return 0;
// }

// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//   int n, m;
//   scanf("%d,%d", &n, &m);
//   int ans = 0;
//   for (int i = n; i <= m; i++) {
//     if (i % 6 == 0) {
//       ans += i;
//     }
//   }
//   printf("%d", ans);
//   return 0;
// }