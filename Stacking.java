public class Stacking
{
private final int SIZE = 20;
private int[] st;
private int top;

public Stacking() 
{
st = new int[SIZE]; 
top = -1;
}
public int pop() 
{ return st[top--]; }

public int peek() 
{ return st[top]; }

public void push(int j) 
{ st[++top] = j; }
public boolean isEmpty() 
{ return (top == -1); }
} 
class Vertex
{
public char label; 
public boolean wasVisited;

public Vertex(char lab) 
{
label = lab;
wasVisited = false;
}
} 
class Traverse
{
private final int MAX_VERTS = 20;
private Vertex vertexList[]; 
private int adjMat[][]; 
private int nVerts; 
private Stacking theStack;

public Traverse() 
{
vertexList = new Vertex[MAX_VERTS];
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
for(int y=0; y<MAX_VERTS; y++) 
for(int x=0; x<MAX_VERTS; x++) 
adjMat[x][y] = 0;
theStack = new Stacking();
} 

public void addingVertexs(char lab)
{
vertexList[nVerts++] = new Vertex(lab);
}

public void addingEdges(int start, int end)
{
adjMat[start][end] = 1;
adjMat[end][start] = 1;
}

public void displayVertex(int v)
{
System.out.print(vertexList[v].label);
}

public void dfs() 
{
vertexList[0].wasVisited = true; 
displayVertex(0); 
theStack.push(0); 

while(!theStack.isEmpty()) 
{

int v = notvisitedVertex( theStack.peek() );
if(v == -1) 
theStack.pop();
else 
{
vertexList[v].wasVisited = true; 
displayVertex(v); 
theStack.push(v); 
}
} 


for(int j=0; j<nVerts; j++) 
vertexList[j].wasVisited = false;
} 


public int notvisitedVertex(int v)
{
for(int j=0; j<nVerts; j++)
if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
return j;
return -1;
} 

} 

class DFSApp
{
public static void main(String[] args)
{
Traverse theGraph = new Traverse();
theGraph.addingVertexs('A'); 
theGraph.addingVertexs('B'); 
theGraph.addingVertexs('C'); 
theGraph.addingVertexs('D'); 
theGraph.addingVertexs('E'); 
theGraph.addingVertexs('F');
theGraph.addingVertexs('G');
theGraph.addingVertexs('H');
theGraph.addingVertexs('I'); 

  

theGraph.addingEdges(0, 1); 
theGraph.addingEdges(0, 4);   
theGraph.addingEdges(0, 3);   
theGraph.addingEdges(1, 4);
theGraph.addingEdges(2, 1);   
theGraph.addingEdges(3, 6);
theGraph.addingEdges(4, 7);
theGraph.addingEdges(4, 5);
theGraph.addingEdges(5, 2);
theGraph.addingEdges(5, 7);
theGraph.addingEdges(6, 7);
theGraph.addingEdges(7, 8);
theGraph.addingEdges(8, 5);

System.out.print("Visited Vertices: ");
theGraph.dfs(); 
System.out.println();
} 
} 
