#include <bits/stdc++.h>
using namespace std;
//需要处理并列的情况 1 1 3 4 5 这种情况
struct stu {
  int id;
  double score[5];
  int Rank[5];
};
stu student[2005];
int now;
bool cmp(stu a, stu b) {  // 降序排列
  return a.score[now] > b.score[now];
}
int rank1[1000000][5];
char sco[4] = {'C', 'M', 'E', 'A'};
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> student[i].id;
    double sum = 0;
    for (int j = 0; j < 3; j++) {
      cin >> student[i].score[j];
      sum += student[i].score[j];
    }
    student[i].score[3] = sum / 3;
  }
  for (now = 0; now < 4; now++) {
    sort(student, student + n, cmp);
    rank1[student[0].id][now] = 1;
    for (int i = 1; i < n; i++) {  // 计算出排名
      if (student[i].score[now] == student[i - 1].score[now]) {  // 并列第一
        rank1[student[i].id][now] = rank1[student[i - 1].id][now];
      } else {
        rank1[student[i].id][now] = i + 1;
      }
    }
  }
  while (m--) {
    int id;
    cin >> id;
    if (!rank1[id][0]) {
      cout << "N/A" << endl;
    } else {
      int k = 3;  // A > C > M > E
      for (int i = 0; i < 4; i++) {
        if (rank1[id][i] < rank1[id][k]) {
          k = i;
        }
      }
      cout << rank1[id][k] << " " << sco[k] << endl;
    }
  }
  return 0;
}
