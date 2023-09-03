#include <bits/stdc++.h>
using namespace std;
const int N = 10005;
vector<int> graph[N];
int tim, tp, cnt;
int dfn[N], low[N], stk[N], insk[N], blong[N];
stack<int> s;
void tarjan(int u) {
  dfn[u] = low[u] = ++tim;
  insk[u] = 1;
  stk[++tp] = u;
  for (int j = 0; j < graph[u].size(); ++j) {
    int v = graph[u][j];
    if (!dfn[v]) {
      tarjan(v);
      low[u] = min(low[u], low[v]);
    } else if (insk[v])
      low[u] = min(low[u], dfn[v]);
  }
  if (dfn[u] == low[u]) {
    int temp;
    ++cnt;
    do {
      temp = stk[tp--];
      insk[temp] = 0;
      blong[temp] = cnt;
    } while (temp != u);
  }
}
int main() {
  int n, m, k, a, b;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d", &a, &b);
    graph[a].push_back(b);
  }
  for (int i = 1; i <= n; ++i)
    if (dfn[i] == 0)
      tarjan(i);
  scanf("%d", &k);
  for (int i = 0; i < k; ++i) {
    scanf("%d %d", &a, &b);
    printf("%s\n", blong[a] == blong[b] ? "Yes" : "No");
  }
}
/*
这段代码是一个基于深度优先搜索 (DFS) 和 Tarjan 算法的有向图连通性判定程序。下面是各个变量的含义解释：

N: 用来表示节点的最大数量，这里设定为 10005。

graph[N]: 这是一个数组，表示有向图的邻接表表示。graph[i] 存储了节点 i 出发的所有边的终点。

tim: 时间戳，用于记录节点被访问的顺序。

tp: 时间戳栈指针，用于记录当前的时间戳。

cnt: 连通分量计数，记录图中连通分量的个数。

dfn[N]: 数组，记录节点的访问时间戳。

low[N]: 数组，记录节点的最早祖先的访问时间戳。

stk[N]: 栈，用于存储节点的访问顺序。

insk[N]: 数组，记录节点是否在栈中。

blong[N]: 数组，记录每个节点所属的连通分量的编号。

s: 栈，存储中间节点。

tarjan(int u): 这是 Tarjan 算法的核心函数，用于从节点 u 开始进行深度优先搜索，并在搜索过程中判断是否存在强连通分量。

scanf("%d %d", &n, &m): 输入节点数量 n 和边的数量 m。

循环 for (int i = 0; i < m; ++i): 用于输入图中的边，每次输入一条边的起点 a 和终点 b，并将终点 b 添加到起点 a 的邻接表中。

for (int i = 1; i <= n; ++i): 对每个节点进行遍历，如果该节点还未被访问过（dfn[i] == 0），则从该节点开始运行 tarjan 函数。

tarjan 函数中的循环：遍历节点 u 的邻接表，处理每条边。

scanf("%d", &k): 输入查询的次数 k。

循环 for (int i = 0; i < k; ++i): 对于每次查询，输入查询的起点 a 和终点 b，然后判断节点 a 和节点 b 是否在同一个强连通分量中，如果是则输出 "Yes"，否则输出 "No"。

总之，这段代码的目标是判断有向图中任意两个节点是否属于同一个强连通分量（即在同一个环中）。这是通过 Tarjan 算法实现的，它通过 DFS 的方式在图中寻找强连通分量，并为每个节点标记访问时间戳、最早祖先访问时间戳和连通分量编号等信息。然后，通过查询操作判断两个节点是否在同一个连通分量中。
*/