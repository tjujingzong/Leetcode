#include <iostream>
#include <string>
#include <vector>

struct Node {
  std::string name;
  int level;
  int parentIndex;  // 使用索引而不是指针
};

void printPath(const std::vector<Node>& nodes, int index) {
  if (index != -1) {
    printPath(nodes, nodes[index].parentIndex);
    if (nodes[index].parentIndex != -1) {
      std::cout << "/" << nodes[nodes[index].parentIndex].name;
    }
  }
}

int main() {
  std::vector<Node> nodes;
  std::string line, name;
  int level;

  // 读取输入并构建结构
  while (std::getline(std::cin, line) && line != "#") {
    level = line.find_first_not_of(' ');
    name = line.substr(level);
    int parentIndex = -1;

    // 设置父节点索引
    for (int i = nodes.size() - 1; i >= 0; --i) {
      if (nodes[i].level == level - 1) {
        parentIndex = i;
        break;
      }
    }

    nodes.push_back({name, level, parentIndex});
  }

  // 读取查询的文件名
  std::string query;
  std::cin >> query;
  bool found = false;

  // 查询并输出路径
  for (int i = 0; i < nodes.size(); ++i) {
    if (nodes[i].name == query) {
      printPath(nodes, i);
      std::cout << '/' << nodes[i].name << std::endl;
      found = true;
    }
  }

  if (!found) {
    std::cout << "NULL" << std::endl;
  }

  return 0;
}
