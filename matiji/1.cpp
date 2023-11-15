#include <stdio.h>
int main() {
  int a = 3, b = 1;
  float d = b / a;
  float c = (float)b / a;
  printf("%f\n", c);
  printf("%-3d", 7);
  printf("%f", d);
  return 0;
}
