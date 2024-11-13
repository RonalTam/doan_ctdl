package dothi;

import java.util.Stack;

class sau {
    public char label;
    public boolean visited;

    public sau(char label) {
        this.label = label;
        this.visited = false;
    }
}

class myGraphDFS {
    private final int maxVertices = 20;
    private final sau[] vertexList;
    private final int[][] adjMatrix;
    private int vertexCount;
    private final Stack<Integer> theStack;

    public myGraphDFS() {
        vertexList = new sau[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack<>();
    }

    public void addsau(char label) {
        vertexList[vertexCount++] = new sau(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displaysau(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public void dfs() {
        vertexList[0].visited = true;
        displaysau(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedsau(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].visited = true;
                displaysau(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < vertexCount; j++) {
            vertexList[j].visited = true;
        }
    }

    public int getAdjUnvisitedsau(int v) {
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[v][j] == 1 && !vertexList[j].visited) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        myGraphDFS g = new myGraphDFS();
        g.addsau('0');
        g.addsau('1');
        g.addsau('2');
        g.addsau('3');
        g.addsau('4');

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(3, 0);
        g.addEdge(4, 2);

        g.dfs();
    }
}

