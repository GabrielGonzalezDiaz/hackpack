import java.util.Scanner;

public class NumberGuesser {

	public static void run(){
		
		System.out.println("Think about a number between 0 and 1000 and I will guess it in less than 20 tries");
		int bottom = 0; 
		int top = 1000;
		int middle = 500;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i <=20; i++){
			System.out.println("Is your number " + middle);
			String ans = scan.next();
			if(ans.equals("yes")){
				System.out.println("I got it!");
				break;
			}else if(ans.equals("H")){
				bottom = middle;
				middle = (top + middle) / 2;
				continue;
				
			}else{
				top = middle;
				middle = (bottom + middle) / 2;
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		
		run();

	}

}
