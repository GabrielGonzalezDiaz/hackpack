import java.util.ArrayList;

public class Prims {

	public static int prim(int[][] adjMat, int ind, boolean[] checked, int len, ArrayList<Integer> checkList){
		checked[ind] = true;
		checkList.add(ind);
		int index = -1;
		int min = Integer.MAX_VALUE;
		for(int row : checkList){
			for(int c=0; c < checked.length; c++)
				if(!checked[c] && adjMat[row][c] < min){
					index = c;
					min = adjMat[row][c];
					}
			}
		if(index == -1)
			return len;
		return prim(adjMat,index, checked, len+min, checkList);
		}
	
	public static void main(String[] args) {
		
		

		}

	}
