#include <iostream>
using namespace std;
int main()
{
  // 请在此输入您的代码
  long long int a[6][2022];
  for (int i = 1; i <= 2021; i++)
  {
    a[2][i] = i - 1;
  }
  for (int j = 3; j <= 5; j++)
  {
    for (int i = 1; i <= 2021; i++)
    {
      for (int k = 1; k < i; k++)
        a[j][i] += a[j - 1][k];
    }
  }
  cout << a[5][2021];
  return 0;
}
