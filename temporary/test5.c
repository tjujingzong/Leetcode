#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct AdjListNode
{
    int dest;
    struct AdjListNode* next;
} AdjListNode;

typedef struct AdjList
{
    AdjListNode* head;
} AdjList;

typedef struct Graph
{
    AdjList* array;
    int num;
} Graph;

AdjListNode* CreateNode(int dest)
{
    AdjListNode* NewNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    NewNode->dest = dest;
    NewNode->next = NULL;
    return NewNode;
}

void AddEdge(Graph* graph, int src, int dest)
{
    AdjListNode* NewNode = CreateNode(dest);
    NewNode->next = graph->array[src].head;
    graph->array[src].head = NewNode;

    NewNode = CreateNode(src);
    NewNode->next = graph->array[dest].head;
    graph->array[dest].head = NewNode;
}

int visited[MAX]={0};
int path[MAX]={0};


void FindCircle(Graph* graph,int v,int start)
{
    int index=0;
    visited[v]=1;
    path[index++]=v;
    AdjListNode* temp=graph->array[v].head;
    while(temp)
    {
        int cur=temp->dest;

        if(visited[cur]==0)
        {
            FindCircle(graph,cur,start);
        }
        else if(cur==start&&index>1)
        {
            printf("找到一个回路:");
            for(int i=0;i<index;i++)
            {
                printf("%d ",path[i]);
            }
            printf("\n");
        }
        temp=temp->next;
    }

    --index;
    visited[v]=0;
}

int main()
{
    int num = 5;
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->num = num;
    graph->array = (AdjList*)malloc(num * sizeof(AdjList));
    for (int i = 0; i < num; i++)
    {
        graph->array[i].head = NULL;
    }

    AddEdge(graph, 0, 1);
    AddEdge(graph, 1, 2);
    AddEdge(graph, 2, 3);
    AddEdge(graph, 3, 4);
    AddEdge(graph, 4, 0);

    FindCircle(graph,0,0);

    return 0;
}
