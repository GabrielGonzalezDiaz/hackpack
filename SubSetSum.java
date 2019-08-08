import java.util.ArrayList;

public class SubSetSum 
	{
	
	static public ArrayList<Integer> subsetSum(int input[], int total)
		{
	    boolean T[][] = new boolean[input.length + 1][total + 1];
	    for (int i = 0; i <= input.length; i++)
	    	{
	    	T[i][0] = true;
	    	}
	    for (int i = 1; i <= input.length; i++)
	    	for (int j = 1; j <= total; j++) 
	    		if (j - input[i - 1] >= 0) 
	    			T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
	            else 
	            	T[i][j] = T[i-1][j];
	    
	    if(T[input.length][total])
	    	{
	    	int s = 0;
	    	ArrayList<Integer> set = new ArrayList<>();
	    	int rr = input.length;
	    	int cc = total;
	    	while(s != total)
	    		{
	    		if(rr-1 >= 0)
	    			{
	    			if(T[rr-1][cc] == false)
	    				{
	    				s += input[rr-1];
	    				set.add(input[rr-1]);
	    				cc -= input[rr-1];
	    				}
	    		rr--;
	    			}
	    		}
	    	return set;
	    	}
	    return null;
	    }
	
	public static void main(String[] args) 
		{
		
		int[] set = {2,1,2,1,5};
		
		int target = 2;
		
		System.out.println(subsetSum(set, target));

		}

	}
