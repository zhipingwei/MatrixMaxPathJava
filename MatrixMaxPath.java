import java.util.*;
public class Main {
	
	int[][] arr = {
				{1,  2,  3,  4,  5,  6,  7,  8},				
				{28, 29, 30, 31, 32, 33, 34, 9},
				{27, 48, 49, 50, 51, 52, 35, 10},
				{26, 47, 60, 61, 62, 53, 36, 11},
				{25, 46, 59, 64, 63, 54, 37, 12},
				{24, 45, 58, 57, 56, 55, 38, 13},
				{23, 44, 43, 42, 41, 40, 39, 14},
				{22, 21, 20, 19, 18, 17, 16, 15}
			};
	
	//{{3,5,2,9},{22,4,7,10},{7,35,20,8},{90,34,1,3}};
	
	
	static int maximumPathLength = 0;
	static int maxPathLength = 0;
	static int originalI = 0;
	static int originalJ = 0;
	ArrayList<Integer> pathLengths = new ArrayList<Integer>();
	static int MaxColumn = 8;
	static int MaxRow = 8;
	
	
	public class Data
	{
		public int x;
		public int y;
		public int value;
	}
	// Class for the node of the tree 
	public class Node
	{
		public Data data;
		// List of children 
		public ArrayList<Node> children;

		public Node parent;

		public boolean  largestNode = false;

		public Node()
		{ 
		    data = new Data();
		    children = new ArrayList<Node>();
		}
		public Node(Data data_)
		{
			children = new ArrayList<Node>();
			data = data_;
		}
	}
		
		public void printPath(Node node)
        {
        	for (Node it : node.children)
        	{
        		if(it.largestNode)
                {
        			System.out.println(Integer.toString(it.data.x) + " " + Integer.toString(it.data.y) + " " + Integer.toString(it.data.value));
        			printPath(it);
        		}				
        	}
        }

	
	public int numTrail(int i, int j, int pathLength)
	{
		int a = arr[i][j];
		
		Node node = new Node();
		
		node.data.x = i;
		node.data.y = j;
		node.data.value = a;
		
		int maxDepth = 0;
		Node maxNode = null;
		int temp = 0;

		if(j + 1 < MaxColumn && a < arr[i][j+1])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i;
			nextNode.data.y = j+1;
			nextNode.data.value = arr[i][j+1];
			node.children.add(nextNode);
			nextNode.parent = node;
					
			temp = numTrail(i, j+1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
			
		}
		if(j - 1 >= 0 && a < arr[i][j-1])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i;
			nextNode.data.y = j-1;
			nextNode.data.value = arr[i][j-1];
			node.children.add(nextNode);
			nextNode.parent = node;
			
			temp = numTrail(i, j-1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(j + 1 < MaxColumn && i + 1 < MaxRow && a < arr[i+1][j+1])
		{	
		    Node nextNode = new Node();
			nextNode.data.x = i+1;
			nextNode.data.y = j+1;
			nextNode.data.value = arr[i+1][j+1];
			node.children.add(nextNode);
			nextNode.parent = node;
			
			temp = numTrail(i+1, j+1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(j + 1 < MaxColumn && i - 1 >= 0 && a < arr[i-1][j+1])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i-1;
			nextNode.data.y = j+1;
			nextNode.data.value = arr[i-1][j+1];
			node.children.add(nextNode);
			nextNode.parent = node;
			
			temp = numTrail(i-1, j+1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(i + 1 < MaxRow && j-1 >= 0 && a < arr[i+1][j-1])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i+1;
			nextNode.data.y = j-1;
			nextNode.data.value = arr[i+1][j-1];
			node.children.add(nextNode);
			nextNode.parent = node;
		
			temp = numTrail(i+1, j-1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(j - 1 >= 0 && i - 1 >= 0 && a < arr[i-1][j-1])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i-1;
			nextNode.data.y = j-1;
			nextNode.data.value = arr[i-1][j-1];
			node.children.add(nextNode);
			nextNode.parent = node;
		
			temp = numTrail(i-1, j-1, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(i + 1 < MaxRow && a < arr[i+1][j])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i+1;
			nextNode.data.y = j;
			nextNode.data.value = arr[i+1][j];
			node.children.add(nextNode);
			nextNode.parent = node;
			
			temp = numTrail(i+1, j, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}
		if(i - 1 >= 0 && a < arr[i-1][j])
		{			
		    Node nextNode = new Node();
			nextNode.data.x = i-1;
			nextNode.data.y = j;
			nextNode.data.value = arr[i-1][j];
			node.children.add(nextNode);
			nextNode.parent = node;
			
			temp = numTrail(i-1, j, pathLength++);
			if (temp > maxDepth)
			{
				maxDepth = temp;
				maxNode = nextNode;
			}	
		}

		if(maxNode != null)
        {
			maxNode.largestNode = true;
		}
		return maxDepth + 1;
	}
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	public void numTrail2(int i, int j, int pathLength, ArrayList<Integer> c)
	{
		
		int a = arr[i][j];
		if (c.size() == maxPathLength-1)
		{
			for (int z = 0; z < c.size(); z++)
			{
				b.set(z, c.get(z));
			}
		}

		if(j + 1 < MaxColumn && a < arr[i][j+1])
		{		
			c.add(arr[i][j+1]);
			numTrail2(i, j+1, pathLength++, c);
		}
		if(j - 1 >= 0 && a < arr[i][j-1])
		{			
			c.add(arr[i][j-1]);
			numTrail2(i, j-1, pathLength++, c);
		}
		if(j + 1 < MaxColumn && i + 1 < MaxRow && a < arr[i+1][j+1])
		{			
			c.add(arr[i+1][j+1]);
			numTrail2(i+1, j+1, pathLength++, c);
		}
		if(j + 1 < MaxColumn && i - 1 >= 0 && a < arr[i-1][j+1])
		{		
			c.add(arr[i-1][j+1]);
			numTrail2(i-1, j+1, pathLength++, c);
		}
		if(i + 1 < MaxRow && j-1 >= 0 && a < arr[i+1][j-1])
		{		
			c.add(arr[i+1][j-1]);
			numTrail2(i+1, j-1, pathLength++, c);
		}
		if(j - 1 >= 0 && i - 1 >= 0 && a < arr[i-1][j-1])
		{		
			c.add(arr[i-1][j-1]);
			numTrail2(i-1, j-1, pathLength++, c);
		}
		if(i + 1 < MaxRow && a < arr[i+1][j])
		{			
			c.add(arr[i+1][j]);
			numTrail2(i+1, j, pathLength++, c);
		}
		if(i - 1 >= 0 && a < arr[i-1][j])
		{		
			c.add(arr[i-1][j]);
			numTrail2(i-1, j, pathLength++,c);
		}

		//pathLengths.add(pathLength);
		if(maxPathLength < pathLength)
		{
			maxPathLength = pathLength;
		}
		//realPaths.add(b);
	}
	
	public Node getNode()
	{
	    return new Node();
	}
	
	public static void main(String[] args)
	{
		Main bob = new Main();
		HashMap<Node, Integer> result = new HashMap<Node, Integer>();
		int currentMax = 0;
		
		
		for(; originalI < MaxColumn; originalI++)
		{
			for(originalJ = 0; originalJ < MaxRow; originalJ++)
			{
				int depth = 0;
				
				depth = bob.numTrail(originalI, originalJ, 1);
			    Node node = bob.getNode();
				node.data.x = originalI;
				node.data.y = originalJ;
				node.data.value = bob.arr[originalI][originalJ];
				
			    if (depth > currentMax)
				{
					currentMax = depth;
					result.clear();
					result.put(node, depth);
				}
				else if (depth == currentMax)
				{
					//potentially multiple solutions
					result.put(node, depth);						
				}
			}
		}
		
		Iterator it = result.entrySet().iterator();
        while (it.hasNext())
		{
		    Map.Entry pair = (Map.Entry)it.next();
		    Node node = (Node)pair.getKey();
			System.out.println(Integer.toString(node.data.x) + " " + Integer.toString(node.data.y) + " " + Integer.toString(node.data.value) + " Depth:" + pair.getValue());
			bob.printPath(node);
		}
		//System.out.println(maxPathLength);
		//System.out.print(bob.b);
		
	}
}

