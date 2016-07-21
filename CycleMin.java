public class Cyclemin 
{
	public static String rotate(String input, boolean direction)
	{
		if(direction == false) //left
		{
			input = input.substring(1) + input.substring(0, 1);
		}
		else //right
		{
			input = input.substring(input.length() - 1, input.length()) + input.substring(0, input.length() - 1);
		}
		return input;
	}
	
	public static boolean s1Smaller(String s1, String s2)
	{
		for(int i = 0; i < Math.max(s1.length(), s2.length()); i++)
		{
			if(s1.charAt(i) < s2.charAt(i))
				return true;
			if(s2.charAt(i) < s1.charAt(i))
				return false;
		}
		return true;
	}
	
	public static String smallestRotation(String input)
	{
		String best = "z";
		for(int i = 0; i <= input.length(); i++)
		{
			System.out.println(input);
			input = rotate(input, true);
			if(s1Smaller(input, best) == true)
				best = input;
		}
		return best;
	}
	
	public static String bestmod(String s, int k)
	{
		if(k <= 0)
			return smallestRotation(s);
		
        char smallest = 'a'; //Delete this?
		
		String best = "z";
		String temp = s;
		for(int i = 0; i < s.length(); i++)
		{
			temp = s.substring(0, i) + smallest + s.substring(i + 1);
			temp = smallestRotation(temp);
			if(s1Smaller(temp, best))
				best = temp;
		}
		
		return bestmod(best, k - 1);
	}
}
