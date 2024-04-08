#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
  int digit;          // 存储数值
  struct Node* prev;  // 指向前一个节点
  struct Node* next;  // 指向后一个节点
} Node, *NodePtr;

void appendNode(NodePtr list, int digit) {
  NodePtr current = list;
  if (current == NULL) {
    return;
  }
  while (current->next) {
    current = current->next;
  }
  NodePtr newNode = (NodePtr)malloc(sizeof(Node));
  newNode->digit = digit;
  current->next = newNode;
  newNode->prev = current;
  newNode->next = NULL;
}

void printListAsNumber(NodePtr list, int decimalPlaces) {
  NodePtr current = list->next;   // 跳过头节点
  printf("%d.", current->digit);  // 打印整数部分
  for (int i = 0; i < decimalPlaces; i++) {
    current = current->next;
    printf("%d", current->digit);
  }
}

int main() {
  // 初始化用于迭代计算每项和存储π近似值的链表
  NodePtr currentTerm, piApproximation;
  currentTerm = (NodePtr)malloc(sizeof(Node));  // 分配内存给当前项的链表
  piApproximation = (NodePtr)malloc(sizeof(Node));  // 分配内存给π近似值的链表
  currentTerm->prev = piApproximation->prev = NULL;  // 初始化链表的prev指针
  currentTerm->next = piApproximation->next = NULL;  // 初始化链表的next指针

  // 获取用户想要计算的π的小数位数
  int decimalPlaces;
  scanf("%d", &decimalPlaces);

  // 初始化链表，填充足够多的节点以确保足够的计算精度
  for (int i = 0; i < 600; i++) {
    appendNode(currentTerm, 0);  // 给当前项的链表添加节点，初始值为0
    appendNode(piApproximation, 0);  // 给π近似值的链表添加节点，初始值为0
  }

  // 定位到链表的起始数位
  NodePtr currentTermDigit = currentTerm->next;  // 当前项的第一个数位
  NodePtr piApproxDigit = piApproximation->next;  // π近似值的第一个数位
  // 设置π近似值的初始值。这里直接设置为2是为了计算的方便，后续计算会修正这个值。
  currentTermDigit->digit = piApproxDigit->digit = 2;

  // 移动到链表的尾部，以便从最低位开始进行迭代计算
  NodePtr currentTermTail = currentTermDigit;  // 当前项的最低数位
  NodePtr piApproxTail = piApproxDigit;        // π近似值的最低数位
  while (currentTermTail->next) {
    currentTermTail = currentTermTail->next;
  }
  while (piApproxTail->next) {
    piApproxTail = piApproxTail->next;
  }

  // 主迭代计算开始
  int carry = 0;  // 用于存储进位
  int divisor;    // 用于存储除数(2n+1)
  // 循环迭代计算每项，这里用了10000次迭代来提高精度
  for (int i = 1, divisor = 3; i < 10; i++, divisor += 2) {
    // 处理乘法，计算当前项的n倍
    NodePtr termDigit = currentTermTail;
    carry = 0;  // 初始化进位
    while (termDigit) {
      int product = termDigit->digit * i + carry;  // 计算当前位的乘积加上进位
      termDigit->digit = product % 10;  // 当前位更新为乘积的个位数
      carry = product / 10;             // 进位更新为乘积的十位数
      termDigit = termDigit->prev;      // 向高位移动
    }

    // 处理除法，计算(n*R(n))/(2n+1)
    carry = 0;                      // 重置进位
    termDigit = currentTerm->next;  // 从链表头部开始
    while (termDigit) {
      int temp = termDigit->digit + carry * 10;  // 乘以10是为了处理下一位的除法
      carry = temp % divisor;  // 新的余数作为下一位计算的“进位”
      termDigit->digit = temp / divisor;  // 当前位更新为除法的商
      termDigit = termDigit->next;        // 向低位移动
    }

    // 将当前项加到π的近似值上
    carry = 0;                        // 重置进位
    NodePtr sumDigit = piApproxTail;  // π近似值的当前位
    termDigit = currentTermTail;      // 当前项的当前位
    while (termDigit && sumDigit) {
      int sum = termDigit->digit + sumDigit->digit + carry;  // 计算总和
      carry = sum / 10;                                      // 更新进位
      sumDigit->digit = sum % 10;  // π近似值的当前位更新为总和的个位数
      termDigit = termDigit->prev;  // 向高位移动
      sumDigit = sumDigit->prev;    // 向高位移动
    }
    printListAsNumber(piApproximation, decimalPlaces);
    printf("     ");
    printListAsNumber(currentTerm, decimalPlaces);
    printf("\n");
  }

  // 输出π的近似值，精确到用户指定的小数位数
  printListAsNumber(piApproximation, decimalPlaces);
  return 0;
}
