#include <iostream>
#include <vector>
#include <algorithm>

std::vector<int> to_base_k(int n, int k)
{
  std::vector<int> result;
  bool negative_base = (k < 0);

  while (n != 0)
  {
    int remainder = n % k;
    n /= k;

    if (negative_base && remainder < 0)
    {
      remainder += abs(k);
      n += 1;
    }

    result.push_back(remainder);
  }

  return result;
}

int main()
{
  int n, k;
  std::cout << "Enter the integer n: ";
  std::cin >> n;
  std::cout << "Enter the base k (k could be negative): ";
  std::cin >> k;

  if (k == 0)
  {
    std::cerr << "Invalid base! Base k cannot be 0." << std::endl;
    return 1;
  }

  std::vector<int> result = to_base_k(n, k);
  std::reverse(result.begin(), result.end());

  std::cout << "The " << k << "-base representation of " << n << " is: ";
  for (int digit : result)
  {
    std::cout << digit;
  }
  std::cout << std::endl;

  return 0;
}
