package org.karticks.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * Given a list of words, detect which ones are anagrams.
 * Input is specified in the following format :
 * N is the number of input words (first line of input)
 * N lines with a word on each line
 * 
 * For example :
 * 6
 * pans
 * pots
 * opt
 * snap
 * stop
 * tops
 * 
 */
public class AnagramDetector
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			
			int numWords = Integer.parseInt(scanner.nextLine());
			
			Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
			for (int i = 0; i < numWords; i++)
			{
				String s = scanner.nextLine();
				
				handleWord(s, table);
			}
			
			scanner.close();
			
			printAnagrams(table.values());
			
		}
		catch (Exception e)
		{
			System.out.println("Caught an exception. Error message : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// most of the dirty work in breaking strings into chars, sorting the chars, and rebuilding
	// the sorted string from the (sorted) chars
	// Once we have the sorted string, we add it to the hashtable (do the requisite check to see if
	// exists ornot) and add the original word to a list (the value)
	private static void handleWord(String s, Hashtable<String, ArrayList<String>> table)
	{
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		
		String key = new String(chars);
		
		ArrayList<String> values;
		if (table.containsKey(key))
		{
			values = table.get(key);
		}
		else
		{
			values = new ArrayList<String>();
		}
		values.add(s);
		table.put(key, values);
	}
	
	private static void printAnagrams(Collection<ArrayList<String>> values)
	{
		for (ArrayList<String> al : values)
		{
			// if there is more than one entry in the list, then we have at least a pair of anagrams
			if (al.size() > 1)
			{
				System.out.println("*************");
				for (String s : al)
				{
					System.out.println(s);
				}
			}
		}
	}
}
