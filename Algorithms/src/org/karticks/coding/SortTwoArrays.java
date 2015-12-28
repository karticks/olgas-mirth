package org.karticks.coding;

/*
 * Given two sorted arrays of different lengths, output an array that is combines the two arrays.
 * The resulting array should also be sorted.
 */

public class SortTwoArrays
{
	public static void main (String[] args)
	{
		try
		{
			int[] array1 = {2, 3, 4, 7, 8, 11, 19, 22, 23, 24, 33, 45, 49};
			int[] array2 = {1, 5, 13, 25, 69};
			
			int[] result = new int[array1.length + array2.length];
			
			int i = 0;
			int j = 0;
			int k = 0;
			
			for (k = 0; k < result.length; k++)
			{
				if (i < array1.length && j < array2.length)
				{
					if (array1[i] <= array2[j])
					{
						result[k] = array1[i++];
					}
					else
					{
						result[k] = array2[j++];
					}
				}
				else if (i >= array1.length && j < array2.length)
				{
					result[k] = array2[j++];
				}
				else if (j >= array2.length && i < array1.length)
				{
					result[k] = array1[i++];
				}
				else
				{
					break;
				}
			}
			
			print(result);
		}
		catch (Exception e)
		{
			System.out.println("Caught an exception. Error message : " + e. getMessage());
			e.printStackTrace();
		}
	}
	
	private static void print(int[] array)
	{
		System.out.println("**********************");
		
		for (int i : array)
		{
			System.out.print(i + " ");
		}
		
		System.out.println("\n**********************");
	}

}
