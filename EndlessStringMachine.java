
public class EndlessStringMachine 
{	
	public static String getFragment(String input, String program, int s, int min, int max)
	{
		if(s <= 0)
		{
			while(input.length() - 1 < max) { input += "-"; }
			return input.substring(min - 1, max);
		}
		input = program.replace("$", input);
		return getFragment(input, program, s - 1, min,max);
	}
}
