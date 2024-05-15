package edu.iastate.cs228.hw2;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

import java.io.File;
import edu.iastate.cs228.hw2.Point;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner
{
	private Point[] points;

	private Point medianCoordinatePoint; // point whose x and y coordinates are respectively the medians of
											// the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;

	protected long scanTime; // execution time in nanoseconds.

	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
		if (pts == null || pts.length == 0)
		{
			throw new IllegalArgumentException("Invalid Input");
		}

		points = new Point[pts.length];

		for (int i = 0; i < pts.length; i++)
		{
			points[i] = new Point(pts[i]);
		}

		this.sortingAlgorithm = algo;
	}

	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		sortingAlgorithm = algo;
		int count = getCount(inputFileName);

		if (count % 2 != 0)
		{
			throw new InputMismatchException("Invalid Input");
		}

		points = new Point[count / 2];
		File f = new File(inputFileName);
		Scanner scan = new Scanner(f);

		for (int i = 0; i < points.length; i++)
		{
			points[i] = new Point(scan.nextInt(), scan.nextInt());
		}

		scan.close();
	}

	/*
	 * Helper method to get count
	 */
	private int getCount(String fileName) throws FileNotFoundException
	{
		File f = new File(fileName);
		Scanner scnr = new Scanner(f);
		int count = 0;

		while (scnr.hasNextInt())
		{
			scnr.nextInt();
			count++;
		}

		scnr.close();

		return count;
	}

	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * @param algo
	 * @return
	 */
	public void scan()
	{
		AbstractSorter aSorter = null;

		if (sortingAlgorithm == Algorithm.InsertionSort)
		{
			aSorter = new InsertionSorter(points);
		}

		else if (sortingAlgorithm == Algorithm.SelectionSort)
		{
			aSorter = new SelectionSorter(points);
		}

		else if (sortingAlgorithm == Algorithm.MergeSort)
		{
			aSorter = new MergeSorter(points);
		}

		else if (sortingAlgorithm == Algorithm.QuickSort)
		{
			aSorter = new QuickSorter(points);
		}

		aSorter.setComparator(0);
		long startTimeX = System.nanoTime();
		aSorter.sort();
		long xTime = System.nanoTime() - startTimeX;
		Point midX = aSorter.getMedian();

		aSorter.setComparator(1);
		long startTimeY = System.nanoTime();
		aSorter.sort();
		long yTime = System.nanoTime() - startTimeY;
		scanTime = xTime + yTime;
		Point midY = aSorter.getMedian();

		int x = midX.getX();
		int y = midY.getY();

		medianCoordinatePoint = new Point(x, y);
	}

	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		if (sortingAlgorithm == Algorithm.SelectionSort || sortingAlgorithm == Algorithm.InsertionSort)
		{
			return sortingAlgorithm.toString() + "    " + points.length + "  " + scanTime;
		}
		
		return sortingAlgorithm.toString() + "        " + points.length + "  " + scanTime;
	}

	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		return "MCP: " + medianCoordinatePoint.toString();
	}

	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException
	{
		File f = new File(sortingAlgorithm.toString() + ".txt");
		PrintWriter pw = new PrintWriter(f);
		pw.write(toString());
		pw.close();
	}
}
