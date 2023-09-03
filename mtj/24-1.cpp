#include <iostream>
#include <string>
using namespace std;

string addStrings(string num1, string num2) {
  string result = "";
  int carry = 0;

  int i = num1.size() - 1;
  int j = num2.size() - 1;

  while (i >= 0 || j >= 0 || carry > 0) {
    int digit1 = i >= 0 ? num1[i] - '0' : 0;
    int digit2 = j >= 0 ? num2[j] - '0' : 0;

    int sum = digit1 + digit2 + carry;
    carry = sum / 10;
    result = char(sum % 10 + '0') + result;

    i--;
    j--;
  }

  return result;
}

string multiplyString(string num, int factor) {
  string result = "";
  int carry = 0;

  for (int i = num.size() - 1; i >= 0; i--) {
    int digit = num[i] - '0';
    int product = digit * factor + carry;
    carry = product / 10;
    result = char(product % 10 + '0') + result;
  }

  while (carry > 0) {
    result = char(carry % 10 + '0') + result;
    carry /= 10;
  }

  return result;
}

string powerOfTwo(int n) {
  string result = "1";

  for (int i = 0; i < n; i++) {
    result = multiplyString(result, 21);
  }

  return result;
}

int main() {
  int n;
  cin >> n;

  if (n == 0) {
    cout << "1" << endl;
  } else {
    string result = powerOfTwo(n);
    cout << result << endl;
  }

  return 0;
}
