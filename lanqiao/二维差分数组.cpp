#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n, m, q;
  cin >> n >> m >> q;

  // Initialize the original matrix and the difference matrix
  vector<vector<int>> matrix(n + 5, vector<int>(m + 5, 0));
  vector<vector<int>> diff(n + 5, vector<int>(m + 5, 0));

  // Input initial values of the matrix
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      cin >> matrix[i][j];
      // Update the difference matrix
      diff[i][j] = matrix[i][j] - matrix[i - 1][j] - matrix[i][j - 1] +
                   matrix[i - 1][j - 1];
    }
  }
  // Perform q operations
  while (q--) {
    int x1, y1, x2, y2, c;
    x1--, y1--, x2--, y2--;
    cin >> x1 >> y1 >> x2 >> y2 >> c;
    // Update the difference matrix based on the operation
    diff[x1][y1] += c;
    diff[x1][y2 + 1] -= c;
    diff[x2 + 1][y1] -= c;
    diff[x2 + 1][y2 + 1] += c;
  }

  // Calculate the final matrix based on the difference matrix
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      matrix[i][j] = diff[i][j] + matrix[i - 1][j] + matrix[i][j - 1] -
                     matrix[i - 1][j - 1];
      cout << matrix[i][j] << " ";
    }
    cout << endl;
  }

  return 0;
}
