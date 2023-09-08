#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long Numerator[n], Denominator[n];
  for (int i = 0; i < n; i++) {
    scanf("%lld/%lld", &Numerator[i], &Denominator[i]);
  }
  long long sumNumerator = 0, sumDenominator = 1;
  for (int i = 0; i < n; i++) {
    sumNumerator =
        sumNumerator * Denominator[i] + sumDenominator * Numerator[i];
    sumDenominator = sumDenominator * Denominator[i];
  }
  long long gcd = __gcd(sumNumerator, sumDenominator);
  if (gcd == 0) {
    cout << 0;
    return 0;
  }
  sumNumerator /= gcd;
  sumDenominator /= gcd;

  if (sumDenominator == 1) {
    cout << sumNumerator;
  } else if (sumNumerator > sumDenominator) {
    cout << sumNumerator / sumDenominator << " "
         << sumNumerator % sumDenominator << "/" << sumDenominator;
  } else {
    cout << sumNumerator << "/" << sumDenominator;
  }
  return 0;
}