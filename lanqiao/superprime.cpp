#include <bits/stdc++.h>

using namespace std;

// 判断一个数是否为质数，是则返回true，不是返回false
bool Prime_Number_Judge(const int &num)
{
  if (num <= 3) // 判断是否小于3
  {
    return num > 1;
  }
  if (num % 6 != 1 && num % 6 != 5) // 判断是否为6x-1或者6x+1
  {
    return false;
  }
  if (num % 2 == 0) // 判断能否被2整除
  {
    return false;
  }
  for (size_t i = 3; i < sqrt(num); i += 2) // 判断能否被小于自身的数整除
  {
    if (num % i == 0)
    {
      return false;
    }
  }
  return true;
}

// 求一个数字有几位
int Get_Number_Size(const int &num)
{
  int digitt = 0;
  int val = num;
  while (val)
  {
    val /= 10;
    digitt++;
  }
  return digitt;
}

// 将一个数的所有位数返回出来
vector<int> &Get_Digits(const int &num, vector<int> &digits)
{
  int vactor_val = 0;
  // 利用Get_Number_Size()求得数字有几位，并进行求余和整除计算
  for (size_t num_size = Get_Number_Size(num); num_size > 0; num_size--)
  {
    vactor_val = num % (int)pow(10.0, num_size);
    vactor_val = vactor_val / (int)pow(10.0, num_size - 1);
    digits.push_back(vactor_val);
  }
  return digits;
}

// 求出全部子串
vector<int> &Get_K_Adjacent(const int &num, vector<int> &adjacent)
{
  vector<int> digists_number;
  // 数字的每位数字分别用数组表示，存在数组digists_number
  Get_Digits(num, digists_number);
  int digits = Get_Number_Size(num);
  for (size_t i = 0; i < digits; i++)
  {
    for (size_t j = 0; j < digits - i; j++)
    {
      string buf;
      int k = 0;
      while (k <= i)
      {
        // 用字符串的+=操作符进行子串的拼接
        buf += to_string(digists_number.at(j + k));
        k++;
      }
      // 再将拼接的子串转为整数，存在数组adjacent
      adjacent.push_back(stoi(buf));
    }
  }
  return adjacent;
}

int main()
{
  // 依次检查1-10000是否为素数
  for (size_t i = 1; i < 1000000; i++)
  {
    if (Prime_Number_Judge(i))
    {
      // 在得出的素数中进行超级素数的检查
      vector<int> buf;
      Get_K_Adjacent(i, buf);
      // sign作为标记，标记是否子串中有非质数，如果有则置为0
      int sign = 1;
      for (size_t j = 0; j < buf.size(); j++)
      {
        if (!Prime_Number_Judge(buf.at(j)))
        {
          // 出现非质数，标记置为0
          sign = 0;
          break;
        }
      }
      if (sign)
      {
        cout << i << "is super_prime_number" << endl;
      }
    }
  }
  return 0;
}