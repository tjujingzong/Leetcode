#include <cstdio>

int main() {
  int n;
  scanf("%d", &n);
  while (n-- > 0) {
    char s[35];  // 假设字符串长度不超过 15
    scanf("%s", s);
    int len = 0;
    while (s[len] != '\0') {
      len++;
    }
    int ans = 0;
    for (int i = 0; i < len; i++) {
      if (s[i] != '-')
        ans = ans * 3 + s[i] - '0';
      else
        ans = ans * 3 - 1;
    }
    printf("%d\n", ans);
  }
  return 0;
}
