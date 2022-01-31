import java.util.*;
public class BalancedBrackets{
	static boolean BalancedBracs(String balbrks)
	{
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < balbrks.length(); i++)
		{
			char x = balbrks.charAt(i);
			if (x == '(' || x == '[' || x == '{')
			{
				stack.push(x);
				continue;
			}
			if (stack.isEmpty()) 
				return false;
			char check;
			switch (x) 
			{
				case ')':	check = stack.pop();
							if (check == '{' || check == '[')
							return false;
							break;
				case '}':	check = stack.pop();
							if (check == '(' || check == '[')
							return false;
							break;
				case ']':	check = stack.pop();
							if (check == '(' || check == '{')
							return false;
							break;
			}
		}
		return (stack.isEmpty());
	}
	public static void main(String[] args)
	{
		String balbrks = "()()()()()"; //Input values here
		if (BalancedBracs(balbrks))
			System.out.println("The brackets are Balanced!");
		else
			System.out.println("The brackets are Not Balanced!!");
	}
}
