

public class SortingDriver {

	public static void fillArray(int[] a){
		for(int i=0; i < a.length; i++)
			a[i] = (int)(1000*Math.random());
		System.out.println();
		
	}
	
	public static int[] RadixSort(int[] a){
		return a;
	}
	
	public static String[] BubbleSortStr(String[] a){
		
		for(int i=0; i < a.length-1; i++){
			for(int j=0; j < a.length-1-i; j++){
				if(a[j].charAt(0) > a[j+1].charAt(0)){
					String temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		return a;
		
	}
	
	public static int[] SelectionSort(int[] a){
		for(int i=0; i < a.length-1; i++) {
			int mindex=i;
			for(int j=i+1; j<a.length; j++){
			 if(a[j] < a[mindex])
			mindex = j;
			}
			if(mindex != i) {
			 int t = a[i];
			 a[i] = a[mindex];
			 a[mindex]= t;
			}
			 }
		return a;
	}
	
	public static int[] bubbleSort(int[] a){

		int[] b = a;
		for(int i=0; i < b.length-1; i++){
			for(int j=0; j < b.length-1-i; j++){
				if(b[j] > b[j+1]){
					int temp = b[j];
					b[j] = b[j+1];
					b[j+1] = temp;
				}
			}
		}
		return b;
	
	}
	public static void print(int[] a){
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void print(String[] a){
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[1000000];
		String[] b = {"b","j","a"};
		//fillArray(a);
		print(b);
		
		//bubbleSort(a);
		//SelectionSort(a);
		//binarySearch(a);
		BubbleSortStr(b);
		
		
		print(b);

	}

}
