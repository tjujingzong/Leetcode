#include <iostream>
using namespace std;
long long a[100010], b[100010]; // 开两个数组，一个保存上一行那一半的数，一个保存目的行那一半的数
int main()
{
  a[0] = 1;
  b[0] = 1;
  long long n;
  cin >> n;
  if (n == 1)
  {
    cout << 1;
    return 0;
  }
  for (int i = 3; i <= 44723; i++)
  {                // 这个是最高循环次数，你可以自己找
    int m = i / 2; // 只要一半
    for (int j = 1; j <= m; j++)
    {
      if (j == m && i % 2 == 1)
      { // 如果行数为奇数那么就有个中间数，就是上一行前面数的两倍
        b[j] = a[j - 1] * 2;
      }
      else
      {
        b[j] = a[j - 1] + a[j]; // 杨辉三角
      }
      a[j - 1] = b[j - 1]; // 更新a数组
      if (b[j] == n)
      {
        cout << i * (i - 1) / 2 + j + 1; // 输出
        return 0;
      }
    }
    a[m] = b[m]; // 更新a数组
    if (b[1] > n)
    { // 快速判断，我们想想，在没找到目的数之前，如果有一行的第二个数比目的数还要大，那么肯定就不会再次出现，直接快速判断输出结果为n行的第二个数。
      cout << n * (n + 1) / 2 + 2;
      return 0;
    }
  }
  cout << n * (n + 1) / 2 + 2; // 防止溢出
  return 0;
}
