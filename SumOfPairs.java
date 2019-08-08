
public class SumOfPairs {

	public static boolean findPair(int[] nums, int target)
	{
		int start = 0;
		int end = nums.length-1;
		for(int i=0; i < nums.length; i++)
		{
			if(end - start < 1)
			{
				return false;
			}
			
			else if(nums[start] + nums[end] == target)
			{
				return true;
			}
			
			else if(nums[start] + nums[end] > target) end--;
			else start++;
			
		}
		
		return false;
	}
	
	public static void selectionsort(int[] nums){
		
		int endindex = nums.length-1;
		
		for(int j=0; j < nums.length; j++)
		{
			int max = 0;
			for(int i=1; i < nums.length - j; i++)
			{
				if(nums[max] < nums[i]) 
					max = i;
			}
			int backup = nums[endindex];
			nums[endindex] = nums[max];
			nums[max] = backup;
			endindex--;
		}
		
	}
	
	public static void main(String[] args) {
		
		//int[] test = {7,6,5,11,25,9,7,58,962,4876,1452,4236,1};
		
		int[] test = new int[10];
		
		for(int i=0; i < test.length; i++)
		{
			test[i] = (int)Math.floor(Math.random()* 10);
		}
		
		for(int i=0; i < test.length; i++)
		{
			System.out.print(test[i] + " ");
		}
		
		System.out.println();
		
		selectionsort(test);
		
		for(int i=0; i < test.length; i++)
		{
			System.out.print(test[i] + " ");
		}
		
		System.out.println();
		
		long start = System.currentTimeMillis();
		
		System.out.println(findPair(test, 6));
		
		long end = System.currentTimeMillis();
		
		System.out.println("Program took " + ((end-start)/1000) + " Second(s)");
		
	}

}
