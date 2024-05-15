package edu.iastate.cs228.hw2;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort,
 * mergesort, and quicksort, over randomly generated integers as well integers
 * from a file input. It compares the execution times of these algorithms on the
 * same input.
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class CompareSorters
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{	
		PointScanner[] scanners = new PointScanner[4];
		Point[] points = null;
		
		System.out.println("Performances of Four Sorting Algorithms in Point Scanning" + "\n");
		System.out.println("keys: 1 (random integers)  2 (file input)  3 (exit) ");
		Scanner scan = new Scanner(System.in);
		
		int choice = 0;
		int trials = 1;

		while (choice != 3)
		{
			if (trials >= 2)
			{
				System.out.println("");
			}
			
			System.out.print("Trial " + trials + ": ");
			trials++;
			choice = scan.nextInt();

			if (choice == 1)
			{
				System.out.print("Enter number of random points: ");
				System.out.print("");
				int numPts = scan.nextInt();
				points = generateRandomPoints(numPts, new Random());

				scanners[0] = new PointScanner(points, Algorithm.SelectionSort);
				scanners[1] = new PointScanner(points, Algorithm.InsertionSort);
				scanners[2] = new PointScanner(points, Algorithm.MergeSort);
				scanners[3] = new PointScanner(points, Algorithm.QuickSort);

			}

			else if (choice == 2)
			{
				System.out.println("Points from a file");
				System.out.print("File name: ");
				String fileName = scan.next();

				scanners[0] = new PointScanner(fileName, Algorithm.SelectionSort);
				scanners[1] = new PointScanner(fileName, Algorithm.InsertionSort);
				scanners[2] = new PointScanner(fileName, Algorithm.MergeSort);
				scanners[3] = new PointScanner(fileName, Algorithm.QuickSort);

			}

			else if (choice == 3)
			{
				System.out.println("");
				System.out.print("Exiting...");
				break;
			}

			else
			{
				System.out.println("");
				System.out.print("Invalid input, Exiting...");
				break;
			}

			System.out.println("");
			System.out.println("algorithm        size  time (ns)");
			System.out.println("---------------------------------- ");

			for (int i = 0; i < scanners.length; i++)
			{
				scanners[i].scan();
				scanners[i].writeMCPToFile();
				System.out.println(scanners[i].stats());
			}

			System.out.println("---------------------------------- ");
		}

		scan.close();
	}

	// Conducts multiple rounds of comparison of four sorting algorithms. Within
	// each round,
	// set up scanning as follows:
	//
	// a) If asked to scan random points, calls generateRandomPoints() to initialize
	// an array
	// of random points.
	//
	// b) Reassigns to the array scanners[] (declared below) the references to four
	// new
	// PointScanner objects, which are created using four different values
	// of the Algorithm type: SelectionSort, InsertionSort, MergeSort and QuickSort.
	//

	// For each input of points, do the following.
	//
	// a) Initialize the array scanners[].
	//
	// b) Iterate through the array scanners[], and have every scanner call the
	// scan()
	// method in the PointScanner class.
	//
	// c) After all four scans are done for the input, print out the statistics
	// table from
	// section 2.
	//
	// A sample scenario is given in Section 2 of the project description.

	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] × [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{
		if (numPts < 1)
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		Point[] points = new Point[numPts];
		rand = new Random();
		for (int i = 0; i < numPts; i++)
		{
			int x = rand.nextInt(101) - 50;
			int y = rand.nextInt(101) - 50;
			points[i] = new Point(x, y);
		}
		return points;
	}

}
