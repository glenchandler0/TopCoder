import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrossWordPuzzle 
{	
	public int countWords(String[] board, int size)
	{
		String fullString = "";
		for(int i = 0; i < board.length; i++) { fullString += board[i] + "\n"; }
		System.out.println(fullString);
		
		int count = 0;
		
		int previousEnd = -1;
		Pattern rgx = Pattern.compile("(?<!\\.)\\.{" + size + "}(?!\\.)");
		Matcher m = rgx.matcher(fullString);
		
		while(m.find())
		{				
			count++;
		}		
		
		return count;
	}
}