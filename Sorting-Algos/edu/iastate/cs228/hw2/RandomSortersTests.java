package edu.iastate.cs228.hw2;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

public class RandomSortersTests
{
	Point[] points;

	@Before
	public void SetupPoints()
	{
		Random rand = new Random();
		points = new Point[rand.nextInt(1001)];
		for (int i = 0; i < points.length; i++)
		{
			points[i] = new Point(rand.nextInt(101)-50, rand.nextInt(101)-50);
		}
	}

	@Test
	public void SelectionSortTestX()
	{
		Point.xORy = true;
		SelectionSorter selectionSorter = new SelectionSorter(points);
		selectionSorter.setComparator(0);
		selectionSorter.sort();
		//selectionSorter.getPoints(points);
		
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (selectionSorter.points[i - 1].compareTo(selectionSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void SelectionSortTestY()
	{
		Point.xORy = false;
		SelectionSorter selectionSorter = new SelectionSorter(points);
		selectionSorter.setComparator(1);
		selectionSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (selectionSorter.points[i - 1].compareTo(selectionSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void InsertionSortTestX()
	{
		Point.xORy = true;
		InsertionSorter insertionSorter = new InsertionSorter(points);
		insertionSorter.setComparator(0);
		insertionSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (insertionSorter.points[i - 1].compareTo(insertionSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void InsertionSortTestY()
	{
		Point.xORy = false;
		InsertionSorter insertionSorter = new InsertionSorter(points);
		insertionSorter.setComparator(1);
		insertionSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (insertionSorter.points[i - 1].compareTo(insertionSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void MergeSortTestX()
	{
		Point.xORy = true;
		MergeSorter mergeSorter = new MergeSorter(points);
		mergeSorter.setComparator(0);
		mergeSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (mergeSorter.points[i - 1].compareTo(mergeSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void MergeSortTestY()
	{
		Point.xORy = false;
		MergeSorter mergeSorter = new MergeSorter(points);
		mergeSorter.setComparator(1);
		mergeSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (mergeSorter.points[i - 1].compareTo(mergeSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void QuickSortTestX()
	{
		Point.xORy = true;
		QuickSorter quickSorter = new QuickSorter(points);
		quickSorter.setComparator(0);
		quickSorter.sort();
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (quickSorter.points[i - 1].compareTo(quickSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}

	@Test
	public void QuickSortTestY()
	{
		Point.xORy = false;
		QuickSorter quickSorter = new QuickSorter(points);
		quickSorter.setComparator(1);
		quickSorter.sort();
		quickSorter.getPoints(points);
		boolean sorted = true;
		for (int i = 1; i < points.length; i++)
		{
			if (quickSorter.points[i - 1].compareTo(quickSorter.points[i]) > 0)
			{
				sorted = false;
			}
		}

		assertEquals(true, sorted);
	}
}
