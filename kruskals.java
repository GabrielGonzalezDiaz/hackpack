import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



class Edge implements Comparable<Edge>{
	int id1;
	int id2;
	int length;
	
	public Edge(int a, int b, int c) {
		id1 = a;
		id2 = b;
		length = c;
		}

	public int compareTo(Edge e) {
		return this.length - e.length;
		}
	
	
	public String toString(){
		return id1 + " " + id2 + " " + length;
		}
	
	}

public class kruskals {

	static int[] id;
	static int[] rank;
	
	public static int getroot(int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
			}
		return i;
		
		}
	
	public static void main(String[] args) throws IOException{
		
		File infile = new File("moocast.in");
		Scanner scan = new Scanner(infile);

		File outfile = new File("moocast.out");
		PrintWriter write = null;
		try
			{
			write = new PrintWriter(outfile);
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int N = scan.nextInt();
		int[][] coords = new int[N][2];
		int[] rank = new int[N];
		id = new int[N];
		
		for(int i=0; i < N; i++) {
			id[i] = i;
			rank[i] = 1;
			coords[i][0] = scan.nextInt();
			coords[i][1] = scan.nextInt();
			}
		
		for(int i=0; i < N; i++) {
			loop : for(int j=0; j < N; j++) {
				if(i == j)
					continue loop;
				int x1 = coords[i][0];
				int y1 = coords[i][1];
				int x2 = coords[j][0];
				int y2 = coords[j][1];
				int len = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
				edges.add(new Edge(i, j, len));
				}
			}
		
		Collections.sort(edges);
		
		ArrayList<Edge> used = new ArrayList<Edge>();
		
		K : for(Edge e : edges) {
			int a = getroot(e.id1);
			int b = getroot(e.id2);
			if(a == b)
				continue K;
			used.add(e);
			if(rank[a] < rank[b]){
				id[a] = b; 
				rank[b] += rank[a];
				}
			else
				id[b] = a; rank[a] += rank[b];
			}
		
		Collections.sort(used);
		write.println(used.remove(used.size()-1).length);

		
		scan.close();
		write.close();
		}

	}
