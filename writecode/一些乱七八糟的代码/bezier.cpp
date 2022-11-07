#include <iostream>
#include <math.h>
using namespace std;
int fact(int n)
{ //阶乘函数
  if (n == 0)
  {
    return 1;
  }
  else
  {
    int res = 1;
    for (int i = n; i > 0; i--)
    {
      res *= i;
    }
    return res;
  }
}
int pts[4][2] = {{0, -2}, {10, 1}, {20, -2}, {30, 3}};
int len=4;
float bezier(float t)
{                  
  int n = len - 1; 
  float Bt = 0;
  float Xt = 0;
  float Yt = 0;
  for (int i = 0; i <= n; i++)
  {
    Bt = fact(n) / (fact(n - i) * fact(i)) * pow((1 - t), (n - i)) * pow(t, i); //计算伯恩斯坦基底
    Xt += Bt * (pts[i][0]);
    Yt += Bt * (pts[i][1]);
  }
  return Yt;
}
int main()
{
  cout<<bezier(0.5);
}
