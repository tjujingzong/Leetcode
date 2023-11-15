#include <complex.h>
#include <stdio.h>

int main() {
  double _Complex z1 = 3.0 + 4.0 * I;  // 创建一个双精度复数
  double _Complex z2 = 1.0 - 2.0 * I;

  double _Complex sum = z1 + z2;      // 复数相加
  double _Complex product = z1 * z2;  // 复数相乘

  printf("Sum: %f + %fi\n", creal(sum), cimag(sum));
  printf("Product: %f + %fi\n", creal(product), cimag(product));

  return 0;
}
