import java.util.*;
public class CrptoMain {
	public static void main(String [] args)
	{
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		ArrayList<Pair> top100 = new ArrayList<Pair>();
		String text = "";
		
		for(int k = 0; k < args.length; k++)
		{
			text += args[k];
		}
		
		int pairsCount = text.length() - 1;
		String [][] pairsArray = new String[pairsCount][2];
		for(int p = 0; p < pairsArray.length; ++p)
		{
			for(int c = 0; c < 2; ++c)
			{
				pairsArray[p][c] = "";
				
			}
		}
		for(int k = 0; k < pairsCount; k++)
		{
			pairsArray[k][0] += text.substring(k, k+2);
			
			if(!contains(pairsArray[k][0],pairs)) // if it dosn't contain 
			{
				pairs.add(new Pair(pairsArray[k][0],1));
				
			}
			else
			{
				pairs.get(getIndexOfPair(pairsArray[k][0], pairs)).incrementCount();
				
			}
			
		}
		
		/*
		for(int k = 0; k < pairs.size(); ++k)
		{
			System.out.println(pairs.get(k).pair + ": "+ pairs.get(k).count);
		}
		*/
		
		if(pairs.size() > 100)
		{
			top100 = getTop100(pairs);
			for(int k = 0; k < top100.size(); ++k)
			{
			System.out.println(top100.get(k).pair + ": "+ top100.get(k).count);
			
			}
		}
		else
		{
			System.out.println("TEXT SAMPLE TOO SMALL");
		}
		
	}
	
	public static boolean contains(String pair, ArrayList<Pair> pairs)
	{
		for(int k = 0; k < pairs.size(); ++k)
		{
			if(pairs.get(k).pair.equals(pair))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static int getIndexOfPair(String pair, ArrayList<Pair> pairs)
	{
		for(int k = 0; k < pairs.size(); ++k)
		{
			if(pairs.get(k).pair.equals(pair))
			{
				return k;		
			}
			
		}
		
		return 0;
		
	}
	public static ArrayList<Pair> getTop100(ArrayList<Pair> pairs)
	{
		ArrayList<Pair> top100 = new ArrayList<Pair>();

		
		while(top100.size() < 100)
		{
			Pair lagest = pairs.get(0);
			for(int k = 0; k < pairs.size(); ++k)
				{
					if(pairs.get(k).count > lagest.count )
					{
						lagest = pairs.get(k);
					}
			
			
				}
			
		top100.add(lagest);
		pairs.remove(lagest);
		
	}
		return top100;
		}
		

}


