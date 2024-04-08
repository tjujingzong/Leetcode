#include <stdio.h>
#include <stdlib.h>

#define MAX 255

typedef struct {
  char ch[MAX + 1];
  int len;
} SString;

void Get_Next(SString t, int* next) {
  int i = 0, j = -1;
  next[0] = -1;
  while (i < t.len - 1) {
    if (j == -1 || t.ch[i] == t.ch[j]) {
      ++i;
      ++j;
      next[i] = j; // 直接赋值为j，不进行是否相同的判断
    } else {
      j = next[j];
    }
    printf("i: %d, j: %d\n", i, j);
  }
  for(int i = 0; i < t.len; i++) {
    printf("%d ", next[i]);
  }
}

int Index_KMP(SString s, SString t) {
  int n = s.len, m = t.len, pos = -1;
  int* nextval = (int*)malloc(m * sizeof(int));
  Get_Next(t, nextval);

  int i = 0, j = 0;
  while (i < n) {
    if (j == -1 || s.ch[i] == t.ch[j]) {
      i++;
      j++;
    } else {
      j = nextval[j];
    }
    if (j == m) {
      pos = i - m;  // 记录最新的匹配位置
      j = 0;        // 重置j，继续查找下一个可能的匹配
    }
  }

  free(nextval);  // 释放内存
  return pos;
}

int main() {
  SString s = {"abcabcdaaaabba", 12}, t = {"abaabcac", 7};
  int i = Index_KMP(s, t);

  if (i == -1) {
    printf("no \n");
  } else {
    printf("pos: %d\n", i + 1);
  }
  return 0;
}
