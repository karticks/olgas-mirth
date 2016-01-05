package org.karticks.coding;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Playing with the TreeSet class in Java
 * 
 * Output of this class looks like this :
 * 
 * 1
 * 2
 * 3
 * 4
 * 6
 * 7
 * 8
 * 9
 * 10
 * ***********************
 * 1
 * ***********************
 * 10
 * ***********************
 * 6
 * ***********************
 * 4
 * 
 * @author Kartick Suriamoorthy
 *
 */
public class SortedTree
{
	public static void main(String[] args)
	{
		try
		{
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			//set.add(5);
			set.add(3);
			set.add(9);
			set.add(1);
			set.add(10);
			set.add(2);
			set.add(9);
			set.add(8);
			set.add(6);
			set.add(4);
			set.add(7);
			
			Iterator<Integer> iterator = set.iterator();
			
			while (iterator.hasNext())
			{
				System.out.println(iterator.next());
			}			
			System.out.println("***********************");
			
			System.out.println(set.first());
			System.out.println("***********************");
			
			System.out.println(set.last());
			System.out.println("***********************");
			
			System.out.println(set.ceiling(5));
			System.out.println("***********************");
			
			System.out.println(set.floor(5));
		}
		catch (Throwable t)
		{
			System.out.println("Caught an exception. Error : " + t.getMessage());
			t.printStackTrace();
		}
	}
}
