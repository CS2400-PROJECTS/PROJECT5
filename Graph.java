import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
public class Graph {
	
	private int[][] edges;
	private Object[] vertex;
	
	
	public Graph(int n)
	{
		edges = new int [n][n];
		
		vertex = new Object [n];
		
	}
	public void setVertex(int index, Object name)
	{
		vertex[index]=name;
		
	}
	
	public Object getVertex (int index)
	{
		return vertex[index];
		
	}
	public int size() 
	{
		return edges.length;
	}
	
	public void addEdge(int source, int target)
	{
	
		edges[source][target]=1;
		edges[target][source]=1;
	}
	
	public boolean isEdge (int source, int target)
	{
		return edges[source][target]>0;
		
	}
	
	public void removeEdge(int source, int target)
	{
		edges [source][target]=0;
	    edges [target][source]=0;
	}
	public int getWeight (int source, int target)
	{
		return edges[source][target];
	}
	
	public int [] neighbors (int vertex)
	{
		int count = 0;
		for (int i=0; i<edges[vertex].length; i++)
		{
				if (edges[vertex][i]>0)
					count++;
		}
		final int[] answer = new int[count];
		count=0;
		for (int i=0; i<edges[vertex].length;i++)
		{
			if (edges[vertex][i]>0)
				answer[count++]=i;
		}
		return answer;
	}
	
	public int getUnvisitedNeighbor (int vertex, boolean[] visited)
	{
		for (int i=0;i<edges[vertex].length;i++)
		{
			if (edges[vertex][i]>0&&visited[i]==false)
				return i;
		}
		return -1;
	}
	public void print()
	{
		for (int j=0;j<edges.length;j++)
		{
			for (int i=0; i<edges[j].length;i++)
			{
				if (edges[j][i]>0)
					System.out.println(vertex[j]+"->"+":"+edges[j][i]+" ");
		}
		}
			System.out.println();
	}
	
	public void getDFS()
	{
		int n = edges.length;
		boolean visited[]=new boolean[n];
		for(int i=0; i<n;i++)
		{
			visited[i]=false;
		}
		// Random starting node
		Random rand= new Random();
		int randNumber=rand.nextInt(n);
		
		Stack<Integer> myStack= new Stack();
		// Visit the first random node
		visited[randNumber]=true;
		System.out.println (vertex[randNumber]);
		myStack.push(randNumber);
		
		while (!myStack.isEmpty())
		{
			int neighbor = getUnvisitedNeighbor(myStack.peek(), visited);
			if (neighbor==-1)// all neighbors are visited
			{
				myStack.pop(); // pop the vertex
			}
			else {
				visited[neighbor]=true;
				System.out.println(vertex[neighbor]);
				myStack.push(neighbor);
				
			}
		}
		
	}
	public void getBFS(int s) {
		// Mark all vertices as not visited
		int x = edges.length;
		boolean visited[]=new boolean[x];
		// Create a queue
	    LinkedList<Integer> queue = new LinkedList();
	    // Mark the current node as visited and enqueue
	    visited[s] = true;
	    queue.add(s);

	    while (queue.size() != 0) 
	    {
	    	//Dequeue the vertex
	      s = queue.poll();
	      System.out.print(s + " ");
	      // Get the adjecent vertives of the vertex dequeued 
	      // Mark the vertex if it has not been visited
	      Iterator<Integer> i = neighbor[s].listIterator();
	      while (i.hasNext()) {
	        int n = i.next();
	        if (!visited[n]) {
	          visited[n] = true;
	          queue.add(n);
	        }
	      }
	    }
	}
}
