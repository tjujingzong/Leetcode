#include <stdio.h>
#include <stdlib.h>
#define MAX_VERTICES 100

typedef struct AdjListNode {
  int vertex;
  struct AdjListNode* next;
} AdjListNode;

typedef struct {
  AdjListNode* head;  // 邻接表的头指针
} AdjList;

typedef struct {
  int V;           // 顶点数
  AdjList* array;  // 邻接表数组
} Graph;

// 创建图
Graph* createGraph(int V) {
  Graph* graph = (Graph*)malloc(sizeof(Graph));
  graph->V = V;
  graph->array = (AdjList*)malloc(V * sizeof(AdjList));

  for (int i = 0; i < V; ++i) {
    graph->array[i].head = NULL;
  }
  return graph;
}

// 添加边
void addEdge(Graph* graph, int src, int dest) {
  AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
  newNode->vertex = dest;
  newNode->next = graph->array[src].head;
  graph->array[src].head = newNode;

  // 因为是无向图，也要添加反向边
  newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
  newNode->vertex = src;
  newNode->next = graph->array[dest].head;
  graph->array[dest].head = newNode;
}

// 深度优先搜索
void DFS(Graph* graph, int v, int visited[]) {
  visited[v] = 1;
  AdjListNode* temp = graph->array[v].head;
  while (temp != NULL) {
    int adjVertex = temp->vertex;
    if (!visited[adjVertex]) {
      DFS(graph, adjVertex, visited);
    }
    temp = temp->next;
  }
}

// 计算连通分量个数
int countConnectedComponents(Graph* graph) {
  int visited[MAX_VERTICES] = {0};
  int count = 0;
  for (int v = 0; v < graph->V; ++v) {
    if (!visited[v]) {
      DFS(graph, v, visited);
      count++;
    }
  }
  return count;
}

// 释放图
void freeGraph(Graph* graph) {
  for (int i = 0; i < graph->V; i++) {
    AdjListNode* pCrawl = graph->array[i].head;
    while (pCrawl) {
      AdjListNode* temp = pCrawl;
      pCrawl = pCrawl->next;
      free(temp);
    }
  }
  free(graph->array);
  free(graph);
}
int main() {
  int V = 5;
  Graph* graph = createGraph(V);
  addEdge(graph, 0, 1);
  addEdge(graph, 1, 2);
  addEdge(graph, 3, 4);

  printf("Number of connected components: %d\n",
         countConnectedComponents(graph));
  freeGraph(graph);
  return 0;
}
