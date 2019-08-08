import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Node{
	
	char symbol;
	int rank = -1;
	
	HashSet<Node> ngbrs = new HashSet<Node>();
	
	public Node( char symbol ){
		this.symbol = symbol;
		}
	
	void addNgbr(Node s){
		ngbrs.add(s);
		//s.addNgbr(this);
		}
	
	public String toString(){
		return symbol + "" + rank;
		}
	
	}

public class BETTERBDFS {

	public static void putnumbers(Node s)
		{
		HashSet<Node> visited = new HashSet<>();
		ArrayList<Node> q = new ArrayList<>();
		s.rank = 0;
		
		q.add(s);
		
		while(!q.isEmpty())
		{
			Node n = q.remove(0);
			if(visited.contains(n))
			{
				continue;
			}
			else
			{
				visited.add(n);
				for(Node j : n.ngbrs)
				{
					if(!visited.contains(j))
					{
						if(j.rank == -1)
						{
							j.rank = n.rank + 1;
							q.add(j);
							}
						}
					}
				}
			}
		}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//int num = scan.nextInt();
		
		//ArrayList<Node> nodes = new ArrayList<Node>(num);
		
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		
		a.addNgbr(b);
		a.addNgbr(c);
		
		b.addNgbr(a);
		b.addNgbr(d);
		b.addNgbr(e);
		
		c.addNgbr(a);
		
		d.addNgbr(b);
		
		e.addNgbr(b);
		
		Node start = a;
		Node end = e;
		ArrayList<Node> path = new ArrayList<Node>();
		putnumbers(start);
		
		while(end.rank != 0){
			int rank = end.rank-1;
			boolean found = false;
			loop : for(Node n : end.ngbrs)
				if(n.rank == rank){
					path.add(end);
					end = n;
					found = true;
					break loop;
					}
			if(!found)
				break;
		}
		
		if(path.get(path.size()-1).rank == 1)
			path.add(start);
		else
			path = null;
		
		
		if(path != null)
			System.out.println(path);
		else
			System.out.println("Nope");
		
		scan.close();
		
	}

}
