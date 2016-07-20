import java.util.*;

public class ArakiDaisukiDiv2 
{
	public static void main(String[] args)
	{
		String s = "waaiusushioakariusushiodaisuki";
		
		System.out.printf("Amount of tuples is: %d\n", countTuples(s));
	}
	
	static int countTuples(String s)
	{
		if(s.length() < 5)
			return 0;
		
		int count = 0;
		
		for(int length = 1; length < s.length() - 3; length++)
		{
			for(int i = 1; i + length < s.length() - 1; i++)
			{
				String sub = s.substring(i, i + length);
				if(sub == null || sub.length() != length)
					continue;
				int n = s.indexOf(sub, i + length + 1);
				while(n != -1 && n + length < s.length())
				{
					count++;
					n = s.indexOf(sub, n + 1);
				}
			}
		}
		return count;
	}
}
