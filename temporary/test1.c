#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_CHARS 100
#define MAX_CODE_LEN 1000

typedef struct Node {
    char ch;
    int freq;
    struct Node *left, *right;
} Node;

Node* newNode(char ch, int freq, Node* left, Node* right) {
    Node* node = (Node*) malloc(sizeof(Node));
    node->ch = ch;
    node->freq = freq;
    node->left = left;
    node->right = right;
    return node;
}

int cmp(const void *a, const void *b) {
    Node *n1 = *(Node**) a;
    Node *n2 = *(Node**) b;
    return n1->freq - n2->freq;
}

void buildHuffmanTree(Node **nodes, int n, Node** root) {
    while (n > 1) {
        qsort(nodes, n, sizeof(Node*), cmp);
        Node* left = nodes[0];
        Node* right = nodes[1];
        Node* merged = newNode('\0', left->freq + right->freq, left, right);
        nodes[0] = merged;
        nodes[1] = nodes[n-1];
        n--;
    }
    *root = nodes[0];
}

void generateCodes(Node* root, char codes[MAX_CHARS][MAX_CODE_LEN], char* code, int length) {
    if (!root) return;
    if (root->ch != '\0') {
        code[length] = '\0';
        strcpy(codes[root->ch], code);
    }
    if (root->left) {
        code[length] = '0';
        generateCodes(root->left, codes, code, length + 1);
    }
    if (root->right) {
        code[length] = '1';
        generateCodes(root->right, codes, code, length + 1);
    }
}

void encode(char* message, char codes[MAX_CHARS][MAX_CODE_LEN], char* encoded) {
    while (*message) {
        strcat(encoded, codes[*message]);
        message++;
    }
}

void decode(char* encoded, Node* root, char* decoded) {
    Node* current = root;
    int i = 0;
    while (encoded[i]) {
        current = encoded[i++] == '0' ? current->left : current->right;
        if (current->ch) {
            *decoded++ = current->ch;
            current = root;
        }
    }
    *decoded = '\0';
}

int main() {
    int n;
    scanf("%d", &n);

    Node* nodes[MAX_CHARS];
    char chars[MAX_CHARS];
    int freqs[MAX_CHARS];

    for (int i = 0; i < n; i++) {
        scanf(" %c", &chars[i]);
    }
    for (int i = 0; i < n; i++) {
        scanf(" %d", &freqs[i]);
        nodes[i] = newNode(chars[i], freqs[i], NULL, NULL);
    }

    char buffer[MAX_CODE_LEN];
    scanf(" %s", buffer); // 读取剩余输入为报文

    Node* root = NULL;
    buildHuffmanTree(nodes, n, &root);

    char codes[MAX_CHARS][MAX_CODE_LEN] = {0};
    char code[MAX_CODE_LEN];
    generateCodes(root, codes, code, 0);

    char encoded[MAX_CODE_LEN] = {0};
    encode(buffer, codes, encoded);
    printf("%s\n", encoded);

    char decoded[MAX_CODE_LEN];
    decode(encoded, root, decoded);
    printf("%s\n", decoded);

    return 0;
}
