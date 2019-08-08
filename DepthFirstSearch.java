import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
	
	public class Node {
		String val;
		int r, c;
		public Node(String val, int r, int c){
			this.val = val;
			this.r = r;
			this.c = c;
		}
		
		public String toString(){
			return val;
		}
		
		public String ttoString(){
			return r + " " + c;
		}

	}

	/**public static boolean ir(Node[][] map, int r, int c)
	{
		return r > 0 && r < map.length && c > 0 && c < map[0].length;
	}**/
	
	public static void DFS(Node[][] maze, Stack<Node> path, ArrayList<Node> visited, int r, int c)
	{
		if(maze[r][c].val.equals("*")){
			path.add(maze[r][c]);
			return;
		}
		path.add(maze[r][c]);
		visited.add(maze[r][c]);
		
		if(!visited.contains(maze[r-1][c]) && !maze[r-1][c].val.equals("#"))
			DFS(maze, path, visited, r-1, c);
		
		else if(!visited.contains(maze[r][c+1]) && !maze[r][c+1].val.equals("#"))
			DFS(maze, path, visited, r, c+1);
		
		else if(!visited.contains(maze[r+1][c]) && !maze[r+1][c].val.equals("#"))
			DFS(maze, path, visited, r+1, c);
	
		else if(!visited.contains(maze[r][c-1]) && !maze[r][c-1].val.equals("#"))
			DFS(maze, path, visited, r, c-1);
		else {		
			if(path.size() == 1) 
				return;
			else
			{
				path.pop();
				DFS(maze, path, visited, path.peek().r, path.peek().c);
			}
		}

	}	
	
	
		
		
		
	
	
	public static void main(String[] args) 
	{
		
		Node[][] maze = new Node[7][7];
		
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[0].length; c++)
			{
				//if(r == 0 || c == 0 || r == 6 || c == 6)
					//maze[r][c] = new Node("#",r,c);
				//else
					//maze[r][c] = new Node("-",r,c);
			}
		}

		/*int row = 4;
		int col = 3;
				
		maze[row][col] = new Node("*",row,col);
		
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[0].length; c++)
			{
				System.out.print(maze[r][c] + "    ");
			}
			System.out.println();
		}
		
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[0].length; c++)
			{
				System.out.print(maze[r][c].ttoString() + "    ");
			}
			System.out.println();
		}
		
		
		Stack<Node> path = new Stack<>();
		ArrayList<Node> visited = new ArrayList<>();
		
		DFS(maze, path, visited, 1, 1);
		
		System.out.println(path.size());
		
		for(int i = 0; i < path.size(); i++)
		{
			System.out.println(path.get(i).ttoString());
		}
		
		*/
		
	}
	
	

}
