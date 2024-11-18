#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct AdjListNode {
    int dest;
    struct AdjListNode* next;
} AdjListNode;

typedef struct AdjList {
    AdjListNode* head;
} AdjList;

typedef struct Graph {
    AdjList* array;
    int numVertices;
} Graph;

AdjListNode* CreateNode(int dest) {
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    if (newNode == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;
}

void AddEdge(Graph* graph, int src, int dest) {
    AdjListNode* newNode = CreateNode(dest);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;
}

void DFS(Graph* graph, int u, int v, int k, int path[], int index, int visited[]) {
    visited[u] = 1;
    path[index] = u;
    index++;

    if (u == v) {
        for (int i = 0; i < index; i++) {
            printf("%d ", path[i]);
        }
        printf("\n");
    } else {
        AdjListNode* temp = graph->array[u].head;
        while (temp) {
            int adjNode = temp->dest;
            if (!visited[adjNode] && adjNode != k) {
                DFS(graph, adjNode, v, k, path, index, visited);
            }
            temp = temp->next;
        }
    }

    index--;
    visited[u] = 0;
}

void FindAllPaths(Graph* graph, int u, int v, int k) {
    int* path = (int*)malloc(MAX * sizeof(int));
    if (path == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    int visited[MAX] = {0};

    DFS(graph, u, v, k, path, 0, visited);

    free(path);
}

void FreeGraph(Graph* graph) {
    for (int i = 0; i < graph->numVertices; i++) {
        AdjListNode* temp = graph->array[i].head;
        while (temp) {
            AdjListNode* next = temp->next;
            free(temp);
            temp = next;
        }
    }
    free(graph->array);
}

int main() {
    Graph graph;
    graph.numVertices = 5;
    graph.array = (AdjList*)malloc(graph.numVertices * sizeof(AdjList));
    if (graph.array == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < graph.numVertices; i++) {
        graph.array[i].head = NULL;
    }

    AddEdge(&graph, 0, 1);
    AddEdge(&graph, 0, 2);
    AddEdge(&graph, 1, 3);
    AddEdge(&graph, 1, 4);

    printf("All paths from %d to %d avoiding %d:\n", 0, 4, 3);
    FindAllPaths(&graph, 0, 4, 3);

    FreeGraph(&graph);

    return 0;
}

