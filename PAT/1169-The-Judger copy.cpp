#include <cstdio>
#include <map>
#include <unordered_map>
#include <vector>
const int MAXN = 11;
const int MAXM = 1001;

int N, M, u, v, cnt;
int g[MAXM][MAXN];
std::unordered_map<int, int> mp;
std::map<int, int> exist;

int main() {
  scanf("%d %d", &u, &v);
  mp[u] = 1;
  mp[v] = 1;
  scanf("%d %d", &N, &M);
  for (int i = 1; i <= N; ++i) {
    exist[i] = 1;
  }
  cnt = N;
  for (int i = 1; i <= N; ++i) {
    for (int j = 1; j <= M; ++j) {
      scanf("%d", &g[j][i]);
    }
  }
  for (int i = 1; i <= M; ++i) {
    for (int j = 1; j <= N; ++j) {
      if (exist[j]) {
        if (mp.find(g[i][j]) != mp.end()) {
          exist[j] = 0;
          --cnt;
          printf("Round #%d: %d is out.\n", i, j);
          continue;
        }
        auto it = mp.begin();
        while (it != mp.end()) {
          if (mp.find(it->first + g[i][j]) != mp.end() ||
              mp.find(it->first - g[i][j]) != mp.end()) {
            break;
          }
          ++it;
        }
        if (it == mp.end()) {
          exist[j] = 0;
          --cnt;
          printf("Round #%d: %d is out.\n", i, j);
        } else {
          mp[g[i][j]] = 1;
        }
      }
    }
  }
  if (!cnt) {
    printf("No winner.");
  } else {
    printf("Winner(s):");
    for (auto it = exist.begin(); it != exist.end(); ++it) {
      if (it->second) {
        printf(" %d", it->first);
      }
    }
  }
  return 0;
}