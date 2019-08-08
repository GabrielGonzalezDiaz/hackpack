
import java.util.HashSet;
import java.util.PriorityQueue;

class edge {
	int len;
	Dnode to;
	
	public edge( int l, Dnode n ){
		len = l;
		to = n;
		}

	
	}

class Dnode implements Comparable< Dnode > {
	boolean visited = false;
	HashSet< edge > adj = new HashSet< edge >();
	String id;
	int dist = Integer.MAX_VALUE;
	
	public Dnode( String s ){
		id = s;
		}
	
	public void addEdge( Dnode a, int l ){
		adj.add( new edge( l, a ) );
		}

	public int compareTo( Dnode n ) {
		return dist - n.dist;
		}
	
	}

public class Dijkstra {

	public static void newEdge( Dnode a, Dnode b, int l ){
		a.addEdge( b, l );
		b.addEdge( a, l );
		}
	
	public static int[] shortestpath( Dnode[] nodes ) {
		
		PriorityQueue< Dnode > q = new PriorityQueue< Dnode >();
		Dnode start = nodes[0];
		start.dist = 0;
		q.add(start);
		
		while(!q.isEmpty()) {
			Dnode curr = q.remove();
			curr.visited = true;
			
			for(edge e : curr.adj){
				if(!e.to.visited){
					e.to.dist = Math.min(e.to.dist, curr.dist + e.len);
					q.remove(e.to);
					q.add(e.to);
					}
				}
			}
		
		int[] dist = new int[nodes.length];
		
		for(int i=0; i < nodes.length; i++)
			dist[i] = nodes[i].dist;
		
		return dist;
		
		}
	
	public static void main(String[] args) {
		
		Dnode a = new Dnode("A");
		Dnode b = new Dnode("B");
		Dnode c = new Dnode("C");
		Dnode d = new Dnode("D");
		Dnode e = new Dnode("E");
		Dnode f = new Dnode("F");
		Dnode g = new Dnode("G");
		Dnode h = new Dnode("H");

		newEdge(a, b, 5);
		newEdge(c, b, 9);
		newEdge(d, b, 2);
		newEdge(a, d, 6);
		newEdge(a, e, 10);
		newEdge(a, f, 7);
		newEdge(e, h, 11);
		newEdge(f, e, 7);
		newEdge(g, f, 2);
		newEdge(g, h, 4);
		
		Dnode[] nodes = {a,b,c,d,e,f,g,h};
		
		int[] dist = shortestpath(nodes);
		
		for(int i=0; i < dist.length; i++)
			System.out.println(dist[i]);
			
		
		
		}

}
