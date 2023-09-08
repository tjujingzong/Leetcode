#include <iostream>

#include <string.h>

using namespace std;

char a[1000000];

int next1[1000000];

void getnext(int len)

{

  int i = 0, j = -1;

  next1[0] = -1;

  while (i != len) //或者换成for(i=0;i<n;) 注意for循环中的i应该从0开始计数，因为下面有i++也就是说得到的第一个是next1[1]；

  { // next[]的特点是：初值-1，整体右移一位。

    if (j == -1 || a[i] == a[j])

      next1[++i] = ++j; // next[]数组里的放的是i之前（不包括i）的最长前后缀长                                                                           度，且长度是从1开始的。

    else

      j = next1[j];
  }
}

int main()

{

  int n, i, lena, t = 0;

  while (cin >> n && n)

  {

    cin >> a;

    cout << "Test case #" << ++t << endl;

    getnext(n); //这个地方再次写这道题时没注意到，不要用strlen(a)来代替字符串长度，由于输入比较                                                                      大，所以如果用会超时的。

    for (int i = 1; i <= n; ++i) //不要用strlen(a)来代替字符串长度，用n。题目给n的目的就在这呢。

    {

      lena = i - next1[i];

      if (i != lena && i % lena == 0)

        cout << i << " " << i / lena << endl;
    }

    cout << endl;
  }

  return 0;
}