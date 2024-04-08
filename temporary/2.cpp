#define MAX 255
#include <stdio.h>
#include <stdlib.h>

typedef struct {
  char ch[MAX + 1];
  int len;
} SString;

void Get_Nextval(SString t, int* nextval) {
  int i = 0, j = -1;
  nextval[0] = -1;
  while (i < t.len) {
    if (j == -1 || t.ch[i] == t.ch[j]) {
      j++;
      i++;
      if (t.ch[i] != t.ch[j]) {
        nextval[i] = j;
      } else {
        nextval[i] = nextval[j];
      }
    } else {
      nextval[i] = nextval[j];
    }
  }

}

int Index_KMP(SString s, SString t) {
  int n = s.len, m = t.len, pos = -1;
  int* nextval = (int*)malloc(m * sizeof(int));
  Get_Nextval(t, nextval);
  for(int i = 0; i < m; i++) {
    printf("%d ", nextval[i]);
  }
  int i = 0, j = 0;
  while (i < n) {
    while (i < n && j < m) {
      if (j == -1 || s.ch[i] == t.ch[j]) {
        i++;
        j++;
      } else {
        j = nextval[j];
      }
    }

    if (j == m) {
      pos = i - m;
    }
  }

  return pos;
}

int main() {
  SString s = {"abcabcd", 7}, t = {"abc", 3};
  int i = Index_KMP(s, t);

  if (i == -1) {
    printf("%s中没有子串%s\n", s.ch, t.ch);
  } else {
    printf("%s中有子串%s,最后一次出现的位置为:%d", s.ch, t.ch, i + 1);
  }
  return 0;
}