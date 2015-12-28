package org.karticks.coding;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 
 * You are given two arrays A and B that are almost identical but some numbers are missing in A
 * Write a program to figure out the numbers that are in B, but not in A
 * 
 * Notes
 * If a number occurs multiple times in the lists, you must ensure that the frequency of that
 * number in both lists is the same. If that is not the case, then it is also a missing number.
 * You have to print all the missing numbers in ascending order.
 * Print each missing number once, even if it is missing multiple times.
 * 
 * Input Format 
 * There will be four lines of input:
 * n - the size of the first list 
 * This is followed by n space-separated integers that make up the first list. 
 * m - the size of the second list 
 * This is followed by m space-separated integers that make up the second list.
 * 
 * Output Format 
 * Output the missing numbers in ascending order.
 * 
 * Sample Input
 * 10
 * 203 204 205 206 207 208 203 204 205 206
 * 13
 * 203 204 204 205 206 207 205 208 203 206 205 206 204
 * Sample Output
 * 204 205 206
 * 
 */
public class MissingNumbers
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			
			int firstNum = Integer.parseInt(scanner.nextLine());
			String firstLineOfNums = scanner.nextLine();
			int secondNum = Integer.parseInt(scanner.nextLine());
			String secondLineOfNums = scanner.nextLine();
			
			scanner.close();
			
			//System.out.println(firstNum);
			//System.out.println(firstNums);
			//System.out.println(secondNum);
			//System.out.println(secondNums);
			
			// store each number in a Hashtable and the count of each number's occurrence
			Hashtable<String, Integer> firstSet = new Hashtable<String, Integer>();
			processNumbers(firstLineOfNums, firstSet);
			
			// store each number in a Hashtable and the count of each number's occurrence
			Hashtable<String, Integer> secondSet = new Hashtable<String, Integer>();
			processNumbers(secondLineOfNums, secondSet);
			
			// for every number in the second set, see if it is in the first set - if it isn't,
			// then add it to the diffs (missing numbers) list if the number does exist in the
			// first set, but the count in the first set is less than the count in the second
			// set, then add it to the diffs (missing numbers) list also
			Enumeration<String> keys = secondSet.keys();
			
			// using a tree set, so that the output is sorted. If the output doesn't need to be
			// sorted, then just a simple List should suffice
			TreeSet<Integer> diffs = new TreeSet<Integer>();
			while (keys.hasMoreElements())
			{
				String key = keys.nextElement();
				
				if (firstSet.containsKey(key))
				{
					Integer firstValue = firstSet.get(key);
					Integer secondValue = secondSet.get(key);
					
					if (firstValue < secondValue)
					{
						diffs.add(Integer.parseInt(key));
					}
				}
				else
				{
					diffs.add(Integer.parseInt(key));
				}
			}
			
			print(diffs);
						
		}
		catch (Exception e)
		{
			System.out.println("Caught an exception. Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// store each number in a Hashtable and the count of each number's occurrence
	private static void processNumbers(String listOfNums, Hashtable<String, Integer> table)
	{
		String[] numbers = listOfNums.split(" ");
		
		for (String s : numbers)
		{
			Integer num = table.get(s);
			
			if (num == null)
			{
				table.put(s, new Integer(1));
			}
			else
			{
				table.put(s, new Integer(++num));
			}
		}
	}
	
	private static void print(Collection<Integer> coll)
	{
		// print them out
		Iterator<Integer> iterator = coll.iterator();
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
	}
}
