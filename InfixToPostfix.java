import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix 
	{
	
	public static boolean isNum(char c)
		{
		return c != '-' && c != '+' && c != '*'  && c != '/'  && c != '^' && c != '(' && c != ')' && c != '%';
		}
	
	public static int getprec(char a){
		if(a == '+' || a == '-') return 0;
		else if(a == '*' || a == '/' || a == '%') return 1;
		else return 2;
		}
	
	public static boolean higher(char a, char b)
		{
		return getprec(a) > getprec(b);
		}
	
	public static void main(String[] args) 
		{
		
		Scanner scan = new Scanner(System.in);
		
		String exp = scan.nextLine();
		
		char[] infix = exp.toCharArray();
		
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i < infix.length; i++){
			char c = infix[i];
			if(isNum(c))
				System.out.print(c);
			else if(s.isEmpty() || s.peek() == '(')
				s.push(c);
			else if(c == '(')
				s.push(c);
			else if(c == ')'){
				while(s.peek() != '(')
					System.out.print(s.pop());
				s.pop();
				}
			else{
				if(higher(c, s.peek()))
					s.push(c);
				else if(getprec(c) == getprec(s.peek())){
					System.out.print(s.pop());
					s.push(c);
					}
				else{
					while(getprec(c) < getprec(s.peek()))
						System.out.print(s.pop());
					s.push(c);
					}
					
				}
			
			}
		
		while(!s.isEmpty())
			System.out.print(s.pop());
		
		
		scan.close();

		}

	}
