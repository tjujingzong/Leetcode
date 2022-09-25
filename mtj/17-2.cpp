#include <bits/stdc++.h>
using namespace std;

bool check_hash(string &s, pair<int, int> &a, pair<int, int> b)
{ //查看是否是真重复子串还是因为发生哈希碰撞而导致哈希值相同
  for (int i = a.first, j = b.first; i != a.second && j != b.second; ++i, ++j)
  {
    if (s[i] != s[j])
      return false;
  }
  return true;
}
//检查字符串s中是否存在长度为len的重复子串，如果有则返回该子串，否则返回空字符串
string check(string &s, int len)
{
  int base = 26;     //二十六个字母对应二十六进制
  int mod = 1000007; //取模 避免哈希冲突

  int num = 0;
  for (int i = 0; i < len; i++) //计算出第一个len长度的哈希映射值
    num = (num * base + s[i] - 'a') % mod;

  unordered_map<int, pair<int, int>> seen; //存储的是哈希映射值及对应的坐标
  seen.insert({num, {0, len - 1}});

  int al = 1; //根据公式 计算出常数a的len次方
  for (int i = 1; i <= len; i++)
    al = (al * base) % mod;

  //遍历字符串 计算每一个长度为len的子串的哈希映射值
  for (int i = 1; i < s.size() - len + 1; i++)
  {

    //计算长度为len的子串的哈希映射值
    num = num * base - ((s[i - 1] - 'a') * al) % mod;
    while (num < 0)
      num += mod;
    num = (num + (s[i + len - 1] - 'a')) % mod;

    //查找是否有重复的子串
    if (seen.count(num))
      if (check_hash(s, seen[num], {i, i + len - 1}))
        return s.substr(i, len);          //如果是真的存在而不是因为哈希冲突，就返回这个子串
    seen.insert({num, {i, i + len - 1}}); //如果是哈希冲突 就插入
  }
  return "";
}

//返回字符串s最长重复子串
string longestDupSubstring(string s)
{
  int m = s.size();
  int left = 0, right = m;
  string res = "";
  while (left < right)
  {
    int mid = left + (right - left) / 2; //二分法找到最长重复子串
    string tmp = check(s, mid);
    if (!tmp.empty())
    { //如果存在重复子串，就保存下来最长的一个重复子串
      res = tmp.size() > res.size() ? tmp : res;
      left = mid + 1;
    }
    else
      right = mid;
  }
  return res;
}
int main()
{
  string s;
  while (cin >> s)
  {
    cout << longestDupSubstring(s).length() << endl;
  }
}
