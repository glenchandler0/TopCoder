import java.lang.*;
import java.util.ArrayList;

public class Aaagmnrs 
{
	public static void main(String[] args)
	{
		String[] phrases = { "Radar ghost jilts Kim", "patched hers first",  "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
		phrases = anagrams(phrases);
		for(int i = 0; i < phrases.length; i++)
		{
			System.out.printf("%s ", phrases[i]);
		}
	}
	
	public static String[] anagrams(String[] phrases)
	{
		int goodIndexes[] = new int[phrases.length];
        int goodStrs = 0;
		StringBuilder temp;
		StringBuilder temp2;
		
		for(int i = 0; i < phrases.length; i++)
		{
			temp = new StringBuilder(phrases[i].toUpperCase().replace(" ", ""));
			for(int j = i + 1; j < phrases.length; j++)
			{
				//System.out.printf("Length: %d i: %d, j: %d\n", phrases.length, i, j);			
				
				temp2 = new StringBuilder(phrases[j].toUpperCase().replace(" ", ""));
				
				//System.out.printf("This session: %s and %s\n", temp, temp2);
				
				//Comparing the two strings
				while(temp.length() > 0)
				{
					boolean kill = true;
					for(int l = 0; l < temp2.length(); l++)
					{
						if(temp.charAt(0) == temp2.charAt(l))
						{							
							temp.deleteCharAt(0);
							temp2.deleteCharAt(l);
							//System.out.printf("\t%s and %s|| %d, %d\n", temp, temp2, 0 ,l);
							kill = false;
						}
					}
					if(kill == true)
						break;
				}				
				if(temp2.length() == 0)
				{
					//System.out.printf("%s is an anagram of %s\n", phrases[j], phrases[i]);
					phrases[j] = "";
                    goodStrs++;
				}
				
				
				temp = new StringBuilder(phrases[i].toUpperCase().replace(" ", ""));
				
			}//end j for
		} //end i for
		ArrayList<String> retStrs = new ArrayList<String>();
		System.out.printf("Size of arraylist: %d\n", retStrs.size());
		int j = 0;
		for(int i = 0; i < phrases.length; i++)
		{
			if(!(phrases[i].equals("")))
				retStrs.add(phrases[i]);
		}
		System.out.printf("Size of arraylist: %d\n", retStrs.size());
		String[] finalArr = new String[retStrs.size()];
		finalArr = retStrs.toArray(finalArr);
		
		return finalArr;
	}
}
