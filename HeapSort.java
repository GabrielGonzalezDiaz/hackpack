
public class HeapSort {

	public static void fillArray(int[] a){
		for(int i=0; i < a.length; i++)
			a[i] = (int)(1000*Math.random());
		System.out.println();
		
	}
	
	public static int[] newArray(int[] b,int index){
		int[] a = new int[b.length-index];
		for(int i=index; i < a.length;i++){
			a[i] = b[i];
		}
		
		return a;
				
	}
	
	public static int[] heapSort(int[] nums){
		for(int i=0; 2*i + 2 < nums.length;i++){
			if(nums[i] > nums[2*i+1]){
				int temp = nums[i];
				nums[i] = nums[2*i+1];
				nums[2*i+1] = temp;
			}else if(nums[i] > nums[2*i+2]){
				int temp = nums[i];
				nums[i] = nums[2*i+2];
				nums[2*i+2] = temp;
			}
		}	
		
		return nums;
		
	}
	
	public static void main(String[] args) {
		
		int[] a = new int[10];
		fillArray(a);
		for(int i=0; i < a.length;i++){
			System.out.print(a[i] + " "); 
		}
		System.out.println();

		for(int i=0; i < a.length;i++){
			System.out.print(a[i] + " "); 
		}
		
	}

}
