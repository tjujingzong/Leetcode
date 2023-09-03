#include <stdio.h>
int n;               // 要输出的是 1-n 的全排列，n<100
int a[100];          // 记录当前排列
int search(int x) {  // 枚举第 x 个位置的元素{
  if (x == n + 1) {
    for (int i = 1; i <= n; i++)
      printf("%d ", a[i]);
    printf("\n");
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    bool ok = true;
    for (int j = 1; j <= x; j++)
      if (a[j] == i) {
        ok = false;
        break;
      }
    if (ok) {
      a[x] = i;
      search(x + 1);
    }
  }
  return 0;
}
int main() {
  scanf("%d", &n);
  search(1);
  return 0;
}