#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
const int N = 505;
struct Edge {
  int from, to, dis, flag;  // 分别为起点，终点，距离，是否要维修
  Edge(int a, int b, int c, int d) : from(a), to(b), dis(c), flag(d) {}
};
int n, m, a, b, d, f, father[N], cost;
vector<Edge> edges;
// 寻找父亲节点，并进行路径压缩
int findFather(int x) {  // 查找父亲结点并进行路径压缩
  if (x == father[x])
    return x;
  int temp = findFather(father[x]);
  father[x] = temp;
  return temp;
}
// 计算连通分量的个数
int countFather() {
  int cnt = 0;
  for (int i = 1; i <= n; ++i)
    if (father[i] == i)
      cnt += 1;
  return cnt;
}
int main() {
  std::vector<int> result;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d %d %d", &a, &b, &d, &f);
    edges.push_back(Edge(a, b, d, f));
  }
  // 排序的方式按不需要维修的路在前，距离小的路在前
  sort(edges.begin(), edges.end(), [](Edge a, Edge b) {
    return a.flag == b.flag ? a.dis < b.dis : a.flag > b.flag;
  });
  int maxn = 0;
  for (int i = 1; i <= n; ++i) {
    for (int i = 1; i <= n; ++i)
      father[i] = i;
    cost = 0;
    for (Edge e : edges) {
      int ua = findFather(e.from), ub = findFather(e.to);
      if (ua != i && ub != i && ua != ub) {  // 构建连通图
        cost += e.flag == 0 ? e.dis : 0;
        father[ua] = ub;
      }
    }
    // 无法构成连通图
    if (countFather() > 2)
      cost = 0x3f3f3f3f;
    if (cost == maxn)
      result.push_back(i);
    else if (cost > maxn) {
      result.clear();
      maxn = cost;
      result.push_back(i);
    }
  }
  if (maxn == 0)
    printf("0");
  else {
    printf("%d", result[0]);
    for (int i = 1; i < result.size(); ++i)
      printf(" %d", result[i]);
  }
}
