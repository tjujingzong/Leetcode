#include <stdio.h>

#define MAX_DIGITS 10000

void Print_Factorial(const int N);

int main() {
  int N;

  scanf("%d", &N);
  Print_Factorial(N);
  return 0;
}

void Multiply(char result[], int num) {
  int carry = 0;
  for (int i = 0; i < MAX_DIGITS; i++) {
    int digit = (result[i] - '0') * num + carry;
    carry = digit / 10;
    result[i] = (digit % 10) + '0';
  }
}

void Print_Factorial(const int N) {
  if (N < 0) {
    printf("Invalid input\n");
    return;
  }

  char factorial[MAX_DIGITS];
  memset(factorial, '0', sizeof(factorial));
  factorial[0] = '1';

  for (int i = 1; i <= N; i++) {
    Multiply(factorial, i);
  }

  int len = MAX_DIGITS - 1;
  while (len >= 0 && factorial[len] == '0')
    len--;

  if (len == -1) {
    printf("0\n");
    return;
  }

  for (; len >= 0; len--) {
    printf("%c", factorial[len]);
  }
  printf("\n");
}
