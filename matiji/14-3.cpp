#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n, m;
  cin >> n >> m;
  int arr[n];
  for (int i = 0; i < n; i++)
    scanf("%d", &arr[i]);
  sort(arr, arr + n);
  int left = 0, right = arr[n - 1];
  int mid;
  while (left < right)
  {
    mid = left + (right - left) / 2;
    long midt = 0;
    for (int i = n - 1; i >= 0; i--)
    {
      if (mid >= arr[i])
        break;
      midt += (arr[i] - mid);
    }
    if (left == mid)
      break;
    if (midt > m)
      left = mid;
    if (midt < m)
      right = mid;
    if (midt == m)
      break;
  }
  cout << mid << endl;
  return 0;
}