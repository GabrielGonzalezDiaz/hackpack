import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Bnode 
{
	public String id;
	public ArrayList<Bnode> adj = new ArrayList<>();
	public ArrayList<Bnode> par = new ArrayList<>();

	public Bnode(String id)
	{
		this.id = id;
	}
	
	public String toString()
	{
		return id;
	}
	
	public boolean equals(Bnode n)
	{
		return id.equals(n.id);
	}
	
}

public class BreadthFirstSearch {
	
	int level = 1;
	
	public static ArrayList<Bnode> BFS(Bnode s, Bnode end)
	{
		HashSet<Bnode> visited = new HashSet<>();
		ArrayList<Bnode> path = new ArrayList<>();
		ArrayList<Bnode> q = new ArrayList<>();
		
		q.add(s);
		
		while(!q.isEmpty())
		{
			Bnode n = q.remove(0);
			if(visited.contains(n))
			{
				continue;
			}
			else if(n.equals(end))
			{
				path.add(n);
				if(n.par.isEmpty())
					return path;
				
				while(!n.par.isEmpty())
				{
					path.add(n.par.get(0));
					n=n.par.get(0);
				}
				
				Collections.reverse(path);
				
				return path;
			}
			else
			{
				visited.add(n);
				for(Bnode j : n.adj)
				{
					if(!visited.contains(j))
					{
						j.par.add(n);
						q.add(j);
					}
				}
			}
		}
		
		return null;
	}
	
	public static void DFS(Bnode s, Bnode end)
	{
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		Bnode a = new Bnode("A");
		Bnode b = new Bnode("B");
		Bnode c = new Bnode("C");
		Bnode d = new Bnode("D");
		Bnode e = new Bnode("E");
		Bnode f = new Bnode("F");
		Bnode g = new Bnode("G");
		Bnode h = new Bnode("H");
		
		a.adj.add(b);
		a.adj.add(c);
		
		b.adj.add(a);
		b.adj.add(d);
		b.adj.add(f);
		
		c.adj.add(a);
		c.adj.add(e);
		c.adj.add(f);
		
		d.adj.add(b);
		d.adj.add(h);
		
		e.adj.add(c);
		e.adj.add(g);
		
		f.adj.add(b);
		f.adj.add(c);
		
		g.adj.add(e);
		
		h.adj.add(d);
		
		ArrayList<Bnode> path = BFS(a,e);
		
		System.out.println(path.toString());
		

	}

}
