#include "bits/stdc++.h"
using namespace std;

int main()
{
  srand((unsigned)time(NULL));
  for (int i = 0; i < 1; i++)
  {
    cout << "{";
    // for (int j = 0; j < 5; j++)
    // {
    //   cout << "{" << -50 + i * 10 << "," << j * 10 << "," << -rand()%(20)+10 << "}";
    //   if (j != 4)
    //     cout << ",";
    // }
    for (int j = 0; j < 10; j++)
    {
      cout << "{" << -2 + j * 5 << ","  << -0.75+1.5*rand () /double (RAND_MAX)<< "}";
      if (j != 9)
        cout << ",";
    }
    cout << "}"
         << "," << endl;
  }
}