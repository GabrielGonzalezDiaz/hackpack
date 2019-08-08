import java.util.ArrayList;
import java.util.Scanner;


public class mazes {

	public static boolean inBounds(int r, int c, int rows, int cols) {
		return r > -1 && c > -1 && r < rows && c < cols;
		}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		int[] R = {0,1,0,-1};
		int[] C = {1,0,-1,0};
		
		for(int i=1; i <= cases; i++) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			Point[][] map = new Point[rows][cols];
			scan.nextLine();
			int startR = -1;
			int startC = -1;
			for (int r=0; r < rows; r++) {
				char[] line = scan.nextLine().toCharArray();
				for(int c=0; c < cols; c++) {
					if(line[c] == 'S'){
						startR = r;
						startC = c;
						}
					
					map[r][c] = new Point(r,c,line[c]);
					}
				}
			
			
			ArrayList<Point> q = new ArrayList<Point>();
			ArrayList<Point> visited = new ArrayList<Point>();
			q.add(map[startR][startC]);
			visited.add(map[startR][startC]);
			int hay = 0;
			loop : while(!q.isEmpty()) {
				Point curr = q.remove(0);
				if(i == 3)
					System.out.println(curr.r + " " + curr.c + " " + curr.name);
				if(curr.name == 'E')
					break loop;
				if(curr.name == '#')
					hay++;
				for(int j=0; j < 4; j++) {
					int currR = curr.r + R[i];
					int currC = curr.c + C[i];
					if(inBounds(currR, currC, rows, cols) && !visited.contains(map[currR][currC])){
						visited.add(map[currR][currC]);
						if(map[currR][currC].name == '#'){
							q.add(map[currR][currC]);
							}
						else
							q.add(0, map[currR][currC]);
						}
					}
				}
			
			System.out.println(hay);
			
			}
		
		scan.close();

		}

	}

class Point {
	int r;
	int c;
	char name;
	public Point(int a, int b, char n) {
		r=a;
		c=b;
		name = n;
		}
	}
