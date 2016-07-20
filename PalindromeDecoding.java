
public class PalindromeDecoding
{
	
	public static String reverse(String str)
	{
		String retString = "";
		for(int i = str.length() - 1; i >= 0; i--)
		{
			retString += str.charAt(i);
		}
		return retString;
	}
	
	public static String decode(String code, int[] position, int[] length)
	{
		String temp = "";
		for(int i = 0; i < position.length; i++)
		{
			System.out.printf("%d %d\n", position[i], length[i]);
			temp = code.substring(position[i], position[i] + length[i]);
			code = code.substring(0, position[i] + length[i]) + reverse(temp) + code.substring(position[i] + length[i]);
			System.out.println(code);
		}
		return code;
	}
	
	public static void main(String[] args)
	{
		int[] position = {1,2,5};
		int[] length = {1,1,1};
		System.out.println("Return value: " + decode("TC206", position, length));
	}
}
