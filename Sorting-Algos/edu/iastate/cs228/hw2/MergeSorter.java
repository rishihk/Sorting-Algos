package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		algorithm = "mergesort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		int n = pts.length;
		
		if(n<=1) 
		{
			return;
		}
		
		int mid = n/2;
		
		Point[] lh = new Point[mid];
		Point[] rh = new Point[n-mid];
		
		for(int i = 0;i<mid;i++) 
		{
			lh[i] = pts[i];
		}
		
		for(int i=mid;i<n;i++) 
		{
			rh[i-mid] = pts[i];
		}
		
		mergeSortRec(lh);
		mergeSortRec(rh);
		merge(pts, lh, rh);	
	}

	private void merge( Point[] pts, Point[] lh,Point[] rh) 
	{
		int l = lh.length;
		int r = rh.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<l && j<r) 
		{
			if(lh[i].compareTo(rh[j])<=0) 
			{
				pts[k++] = lh[i++];
			}
			
			else 
			{
				pts[k++] = rh[j++];
			}
		}
		
		while(i<l) 
		{
			pts[k++] = lh[i++];
		}
		
		while(j<r) 
		{
			pts[k++] = rh[j++];
		}
	}

}
