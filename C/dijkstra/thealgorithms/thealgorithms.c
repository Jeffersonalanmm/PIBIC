#include <stdio.h>
#include <stdlib.h>

#define MAX 1000
#define INF 999

int mat[MAX][MAX];
int V;

int dist[MAX];

int q[MAX];
int qp = 0;

void enqueue(int v) { q[qp++] = v; }

int cf(void *a, void *b)
{
    int *x = (int *)a;
    int *y = (int *)b;
    return *y - *x;
}

int dequeue()
{
    qsort(q, qp, sizeof(int), cf);
    return q[--qp];
}

int queue_has_something() { return (qp > 0); }

int visited[MAX];
int vp = 0;

void dijkstra(int s)
{
    dist[s] = 0;
    int i;
    for (i = 0; i < V; ++i)
    {
        if (i != s)
        {
            dist[i] = INF;
        }
        enqueue(i);
    }
    while (queue_has_something())
    {
        int u = dequeue();
        visited[vp++] = u;
        for (i = 0; i < V; ++i)
        {
            if (mat[u][i])
            {
                if (dist[i] > dist[u] + mat[u][i])
                {
                    dist[i] = dist[u] + mat[u][i];
                }
            }
        }
    }
}

int main()
{
    V = 1000;  // Define o número de vértices
    srand(time(NULL));

    // Geração de matriz adjacente com valores aleatórios
    for (int i = 0; i < V; ++i)
    {
        for (int j = 0; j < V; ++j)
        {
            if (i != j)
                mat[i][j] = rand() % 100;  // Gera valores aleatórios entre 0 e 99
            else
                mat[i][j] = 0;  // A diagonal da matriz é 0 (nenhum custo para um nó para ele mesmo)
        }
    }

    for (int i = 0; i < V; ++i)
    {
        for (int j = 0; j < V; ++j)
        {
            if (i != j)
                mat[i][j] = rand() % 100;  // Gera valores aleatórios entre 0 e 99
            else
                mat[i][j] = 0;  // A diagonal da matriz é 0 (nenhum custo para um nó para ele mesmo)
        }
    }
    dijkstra(0);

    return 0;
}
