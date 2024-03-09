#include <stdio.h>
#include <string.h>
#include <cstdlib>
struct Grade {
  int Chinese;
  int math;
  int English;
};

struct Stu {
  int num;
  char name[20];
  struct Grade score;
};

int main() {
  int a=2;
  a*=2+3;
  printf("%d",a);
  return 0;
}