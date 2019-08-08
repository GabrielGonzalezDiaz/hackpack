
public class BinarySearch 
{

	public static void fillArray(int[] a){
		for(int i=0; i < a.length; i++) a[i] = i*2;
			
			
			//a[i] = (int)(1000*Math.random());
		//System.out.println();
		
	}
	
	public static int BS(int[] nums, int target)
	{
		int max = nums.length;
		int min = -1;
		
		for(int i=0; i < Math.ceil(Math.log(nums.length) / Math.log(2)); i++)
		{
			
			int index = (max + min) / 2;
			
			if(min + 1 == max) 
			{
				break;
			}
			if(nums[index] == target)
			{
				return index;
			}
			else if(nums[index] > target)
			{
				max = index;
			}
			else
			{
				min = index;
			}
		}
		
		return -1;
		
		
	}
	
	public static void SelectionSort(int[] a){
		for(int i=0; i < a.length-1; i++) 
		{
			int mindex=i;
			for(int j=i+1; j<a.length; j++)
			{
			 if(a[j] < a[mindex])
				 mindex = j;
			}
			if(mindex != i)
			{
				int t = a[i];
				a[i] = a[mindex];
				a[mindex]= t;
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		int[] nums = new int[100];
		fillArray(nums);
		//SelectionSort(nums);
		
		for(int i=0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
		System.out.println(BS(nums, 6));
		

	}

}
