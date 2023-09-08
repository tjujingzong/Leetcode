#include <bits/stdc++.h>
using namespace std;
int num[] = {
    15,
    8,
    1024,
    1024,
    2,
    2,
    2};
string op[] = {
    "|", "/", "^", "|"};
int N = 7, M = 4;

void dfs(int n, string opp, int cnt, string s, bool *numvisit, bool *opvisit)
{
  if (cnt == 3)
  {
    if (n == 1024)
      cout << s.substr(0, s.size() - 1) << endl;
    else
      return;
  }
  for (int i = 0; i < N; i++)
  {
    for (int j = 0; j < M; j++)
    {
      if (!numvisit[i] && !opvisit[j])
      {
        numvisit[i] = true;
        opvisit[j] = true;
        int t = 0;
        if (opp == "+")
          t = n + num[i];
        if (opp == "-")
          t = n - num[i];
        if (opp == "*")
          t = n * num[i];
        if (opp == "/")
          t = n / num[i];
        if (opp == "<<")
          t = n << num[i];
        if (opp == ">>")
          t = n >> num[i];
        if (opp == "^")
          t = n ^ num[i];
        if (opp == "|")
          t = n | num[i];
        if (opp == "&")
          t = n & num[i];
        if (opp == "%")
          t = n % num[i];
        if (opp == "**")
          t = pow(n, num[i]);
        dfs(t, op[j], cnt + 1, "(" + s + to_string(num[i]) + ")" + op[j], numvisit, opvisit);
        numvisit[i] = false;
        opvisit[j] = false;
      }
    }
  }
}
int main()
{
  bool numvisit[N];
  bool opvisit[M];
  memset(numvisit, 0, sizeof(bool) * N);
  memset(opvisit, 0, sizeof(bool) * M);
  for (int i = 0; i < N; i++)
    for (int j = 0; j < M; j++)
    {
      numvisit[i] = true;
      opvisit[j] = true;
      dfs(num[i], op[j], 0, to_string(num[i]) + op[j], numvisit, opvisit);
      numvisit[i] = false;
      opvisit[j] = false;
    }
  cout << (((2^2)/15)|1024);
}