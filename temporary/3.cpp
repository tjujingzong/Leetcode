#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 100
#define OK 1
#define ERROR 0

typedef int Status;
typedef char ElemType;

typedef struct {
  ElemType* data;
  int length;
} SqList;

Status InitList(SqList* L) {
  L->data = (ElemType*)malloc(MAXSIZE * sizeof(ElemType));
  if (!L->data) {
    return ERROR;  // 内存分配失败
  }
  L->length = 0;
  return OK;
}

void createList(SqList* L) {
  char c;
  int i = 0;
  while (i < MAXSIZE && (c = getchar()) != EOF &&
         c != '\n') {  // 修改条件以读取最多100个字符，避免EOF和换行符
    L->data[i++] = c;
  }
  L->length = i;
}

int fch(char c) {
  if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
    return 1;  // 是字母
  } else {
    return 0;  // 不是字母
  }
}

int fnum(char c) {
  if (c >= '0' && c <= '9') {
    return 1;  // 是数字
  } else {
    return 0;  // 不是数字
  }
}

void Sort_Letter(SqList* L) {
  int i = 0, j = L->length - 1;
  char temp;
  // 首先将所有字母移到前面
  while (i < j) {
    while (i < j && fch(L->data[i]))
      i++;
    while (i < j && !fch(L->data[j]))
      j--;
    if (i < j) {
      temp = L->data[i];
      L->data[i] = L->data[j];
      L->data[j] = temp;
    }
  }
  // 然后在所有字母后面排序数字
  i = 0;
  j = L->length - 1;
  while (i < j) {
    while (i < j && !fnum(L->data[i]))
      i++;
    while (i < j && fnum(L->data[j]))
      j--;
    if (i < j) {
      temp = L->data[i];
      L->data[i] = L->data[j];
      L->data[j] = temp;
    }
  }
}

void printList(SqList* L) {
  if (L->length == 0) {
    return;  // 列表为空
  }
  for (int i = 0; i < L->length; i++) {
    printf("%c", L->data[i]);
  }
  printf("\n");
}

int main() {
  SqList L;
  if (InitList(&L) == ERROR) {
    printf("List initialization failed.\n");
    return 1;
  }

  printf("Please enter characters (end with newline): ");
  createList(&L);
  Sort_Letter(&L);
  printList(&L);

  free(L.data);  // 释放分配的内存
  return 0;
}
