#include <bits/stdc++.h>

using namespace std;
int Max(int array[], int len)
{
  int maxBit = sizeof(int) * 8; // 最高位数
  unsigned currBit = 1;         // 当前位
  int mark[len];                // 标记被剔除元素的数组，下标对应相应的元素
  int result = 0;
  for (int i = 0; i < len; i++)
    mark[i] = 1; // 第i个元素为1，表示保留
  currBit = currBit << (maxBit - 1);
  for (int i = 0; i < maxBit; i++)
  {
    // 统计
    int count = 0;
    for (int j = 0; j < len; j++)
    {
      if (mark[j] == 1 && (array[j] & currBit) != 0)
        count++;
    }

    if (count > 1)
    {
      // 剔除
      for (int j = 0; j < len; j++)
      {
        if ((array[j] & currBit) == 0)
          mark[j] = 0; // 标记数组置为0表示剔除
      }
      // 更新结果，如 0100 + 0010 = 0110
      result += currBit;
    }
    // 下一位
    currBit = currBit >> 1;
  }

  return result;
}
int main()
{
  int t;
  long ans = 0;
  cin >> t;
  for (int k = 0; k < t; k++)
  {
    int n;
    cin >> n;
    int a[n];
    long max = 0;
    for (int j = 0; j < n; j++)
    {
      scanf("%d", &a[j]);
    }
    ans += Max(a, n);
  }
  cout << ans;
  return 0;
}
