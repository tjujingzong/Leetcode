#include <algorithm>
#include <iostream>
#include <vector>

// Implementation of Binary Indexed Tree (Fenwick Tree)
class BIT {
 public:
  BIT(int size) : size(size), tree(size + 1, 0) {}

  void update(int index, int value) {
    for (; index <= size; index += index & -index) {
      tree[index] += value;
    }
  }

  int query(int index) {
    int sum = 0;
    for (; index > 0; index -= index & -index) {
      sum += tree[index];
    }
    return sum;
  }

 private:
  int size;
  std::vector<int> tree;
};

int main() {
  int n;
  std::cin >> n;

  std::vector<int> numbers(n);
  for (int i = 0; i < n; ++i) {
    std::cin >> numbers[i];
  }

  // Compress the numbers to a smaller range to make BIT more efficient
  std::vector<int> sorted_numbers = numbers;
  std::sort(sorted_numbers.begin(), sorted_numbers.end());
  for (int i = 0; i < n; ++i) {
    numbers[i] = std::lower_bound(sorted_numbers.begin(), sorted_numbers.end(),
                                  numbers[i]) -
                 sorted_numbers.begin() + 1;
  }

  BIT bit(n);
  std::vector<int> lehmer_code(n);

  for (int i = n - 1; i >= 0; --i) {
    lehmer_code[i] = bit.query(numbers[i] - 1);
    bit.update(numbers[i], 1);
  }

  for (int i = 0; i < n; ++i) {
    std::cout << lehmer_code[i];
    if (i != n - 1) {
      std::cout << " ";
    }
  }
  std::cout << std::endl;

  return 0;
}
