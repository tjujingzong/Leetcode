#include <bits/stdc++.h>
#include <stack>
using namespace std;
enum { RIGHT, DOWN, LEFT, UP };  // 定义方向
typedef struct {
  int x;
  int y;
} pos;  // 坐标类型
typedef struct {
  int ord;                             // 序号
  pos seat;                            // 坐标
  int dir;                             // 方向
} block;                               // 通道块
char maze[20][20];                     // 迷宫
bool foot[20][20] = {0};               // 足迹
void footprint(stack<block>& path);    // 留下脚印
void defootprint(stack<block>& path);  // 消除脚印
bool pass(stack<block>& path);         // 判断是否可以通过
bool end(stack<block>& path);          // 判断是否是终点
void inblock(stack<block>& path);      // 将通道块插入栈顶
int main() {
  stack<block> path;
  block start;
  ifstream file;
  int len, wid;
  file.open("1.txt");                                  // 输入文件
  file >> len >> wid >> start.seat.x >> start.seat.y;  // 读入迷宫的长宽，起点
  for (int i = 0; i < wid; i++) {
    for (int j = 0; j < len; j++) {
      file >> maze[i][j];  // 读入迷宫;#表示障碍，-表示道路，*表示终点
    }
  }
  file.close();
  start.dir = RIGHT;
  start.ord = 0;
  path.push(start);
  footprint(path);
  inblock(path);
  do {
    if (pass(path)) {
      if (end(path))
        break;
      footprint(path);
      inblock(path);

    } else {
      // defootprint(path);
      path.pop();
      if (!path.empty() && path.top().dir == 3) {
        maze[path.top().seat.y][path.top().seat.x] = '!';  // 标记位置
        defootprint(path);
        path.pop();
      }
      if (!path.empty() && path.top().dir < 3) {
        path.top().dir++;
        inblock(path);
      }
    }
  } while (!path.empty());
  // 输出从入口到出口的道路
  stack<block> copy1;
  stack<block> copy2;
  while (!path.empty()) {
    copy1.push(path.top());
    path.pop();
  }
  while (!copy1.empty()) {
    cout << '(' << copy1.top().seat.y << ',' << copy1.top().seat.x << ')';
    copy2.push(copy1.top());
    copy1.pop();
  }
  cout << endl;
  // 在迷宫中显示路径
  while (!copy2.empty()) {
    switch (copy2.top().dir) {
      case RIGHT:
        maze[copy2.top().seat.y][copy2.top().seat.x] = '>';
        break;
      case LEFT:
        maze[copy2.top().seat.y][copy2.top().seat.x] = '<';
        break;
      case DOWN:
        maze[copy2.top().seat.y][copy2.top().seat.x] = 'v';
        break;
      case UP:
        maze[copy2.top().seat.y][copy2.top().seat.x] = '^';
        break;
    }
    copy2.pop();
  }
  for (int i = 0; i < wid; i++) {
    for (int j = 0; j < len; j++) {
      cout << ' ' << maze[i][j];
    }
    cout << endl;
  }
  system("pause");
  return 0;
}
void footprint(stack<block>& path) {
  foot[path.top().seat.y][path.top().seat.x] = 1;
}
void defootprint(stack<block>& path) {
  foot[path.top().seat.y][path.top().seat.x] = 0;
}
bool pass(stack<block>& path) {
  if (maze[path.top().seat.y][path.top().seat.x] != '#' &&
      !foot[path.top().seat.y][path.top().seat.x] &&
      maze[path.top().seat.y][path.top().seat.x] != '!')
    return true;
  return false;
}
bool end(stack<block>& path) {
  if (maze[path.top().seat.y][path.top().seat.x] == '*')
    return true;
  return false;
}
void inblock(stack<block>& path) {
  block temp;
  temp.dir = RIGHT;
  temp.ord = path.top().ord + 1;
  switch (path.top().dir) {
    case RIGHT:
      temp.seat.x = path.top().seat.x + 1;
      temp.seat.y = path.top().seat.y;
      break;
    case LEFT:
      temp.seat.x = path.top().seat.x - 1;
      temp.seat.y = path.top().seat.y;
      break;
    case UP:
      temp.seat.x = path.top().seat.x;
      temp.seat.y = path.top().seat.y - 1;
      break;
    case DOWN:
      temp.seat.x = path.top().seat.x;
      temp.seat.y = path.top().seat.y + 1;
      break;
  }
  path.push(temp);
}