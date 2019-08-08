
public class SieveOfEratosthenes {

	public static int[] fillArray(int[] a){
		for(int i=0; i < a.length; i++){
			a[i] = i;
		}
		
		return a;
	}
	
	public static void sieve(){
		
		int nums = 0;
		int[] list = new int[300000];
		fillArray(list);
		
		for(int i=0; i < list.length; i++){
			if( nums % 10 == 0 )
			{
				System.out.println();
				nums++;
			}
			if(list[i] != 0 && list[i] != 1){
				System.out.print(list[i] + ", ");
				nums++;
				for(int j=i; j < list.length; j+=list[i]){
						if(list[j] != list[i]){
						list[j] = 0;
						}
					}
				}
			}
		}
		
	
	
	
	public static void main(String[] args) {

		sieve();

	}

}
