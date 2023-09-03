#include <algorithm>
#include <cstdio>
#include <cstring>
using namespace std;
const int maxn = 1e3 + 10;
const int size = 62;
const int INF = 0x7FFFFFFF;
const int limit = 178;
char s[maxn];
int n, f[size], now[size], out[maxn][size], ans, cost,
    cnt;  // now[i]表示当前已拿的字符个数。

struct point {
  int f[size], cost, use;
  bool operator<(const point& a) const { return use > a.use; }
} a[maxn];

int get(char c) {
  if ('0' <= c && c <= '9')
    return c - '0';
  if ('a' <= c && c <= 'z')
    return c - 'a' + 36;
  if ('A' <= c && c <= 'Z')
    return c - 'A' +
           10;  // 当字符串较多时，map就会很耗时间，所以用数组来存字符个数。
}  // 同时字符种类很少时，用数组便于枚举
// 相比简易版本，多条意味着有最值问题，用深搜枚举每一种情况，找到这个最小值
void dfs(
    int x,
    int c)  // dfs就是枚举所有已知的字符串。深搜枚举也是取与不取实现全部枚举
{
  cnt++;  // A*减枝的关键是能估算出这个limit的值。
  if (cnt > limit)
    return;  // 对层数的估值
  if (c >= ans)
    return;  // 对结果大小的估值,因为是取最小值，所以一旦大于就舍弃。

  bool flag1 = true, flag2 = false;  // now[i]一开始都为0
  for (int i = 0; i < size; i++)
    if (now[i] + out[x][i] < f[i])
      return;  // 如果最多的还小，肯定是不行，扩大剪枝
  for (int i = 0; i < size; i++)
    if (now[i] < f[i]) {
      flag1 = false;
      break;
    }
  if (flag1) {
    ans = c;
    return;
  }  // 分析剪枝
     // 如果所有now[i]都不比f[i]小的话就不用再找下一条了，已经找完，return
  if (x == n)
    return;  // 找完所有字符串。
  for (int i = 0; i < size; i++)
    if (now[i] < f[i] && a[x].f[i])
      flag2 = true;  // 当前这条链有想要的字符且想要的没取完
  if (flag2) {
    for (int i = 0; i < size; i++)
      now[i] += a[x].f[i];      // 将这条链上所有想要的字符拿走
    dfs(x + 1, c + a[x].cost);  // 取这条进行下一条的搜索
    if (cnt > limit)
      return;
    for (int i = 0; i < size; i++)
      now[i] -= a[x].f[i];  // 枚举所有情况就要有回溯
  }
  dfs(x + 1, c);  // 不取这条，进行下一条
  if (cnt > limit)
    return;
}

int main() {
  scanf("%s%d", s, &n);
  cost = strlen(s);
  for (int i = 0; s[i]; i++)
    f[get(s[i])]++;  // 将字母转成数字，就能用数组表示map的功能记录字母的个数
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    a[i].cost = strlen(s);
    for (int j = 0; s[j]; j++)
      a[i].f[get(s[j])]++, out[0][get(s[j])]++;  // 统计所有字符串相应的字符个数
    for (int j = 0; j < size; j++)
      a[i].use += min(f[j], a[i].f[j]);  // 最小的字母数的总和
  }
  for (int i = 0; i < size; i++)
    if (f[i] > out[0][i])
      ans += f[i] - out[0][i];
  if (ans)
    printf("No %d\n", ans);
  else {
    sort(a, a + n);  // use值从大到小排序，减少搜索次数
    for (int i = n - 1; i >= 0; i--)
      for (int j = 0; j < size; j++)
        out[i][j] = out[i + 1][j] + a[i].f[j];
    ans = INF;
    dfs(0, 0);
    printf("Yes %d\n", ans - cost);
  }
  return 0;
}