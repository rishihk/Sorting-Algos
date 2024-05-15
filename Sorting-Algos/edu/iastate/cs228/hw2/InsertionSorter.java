package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

/**
 * 
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter
{
	// Other private instance variables if you need ...
	

	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts)
	{
		super(pts);
		algorithm = "insertion sort";
	}

	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override
	public void sort()
	{
		for (int i = 1; i < points.length; i++)
		{
			Point temp = points[i];
			int j = i - 1;

			while (j > -1 && points[j].compareTo(temp) > 0)
			{
				points[j + 1] = points[j];
				j--;
			}

			points[j + 1] = temp;
		}
	}
}
