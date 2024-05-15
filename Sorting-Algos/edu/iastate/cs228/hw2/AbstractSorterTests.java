package edu.iastate.cs228.hw2;

/*
 * 
 *  @author - Hrishikesha Kyathsandra
 *  
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractSorterTests
{
	protected Point[] pts;
	protected Point[] sortedX;
	protected Point[] sortedY;
	protected AbstractSorter sorter;

	@BeforeEach
	void setUp()
	{
		pts = new Point[] { new Point(2, 3), new Point(1, 1), new Point(0, 5), new Point(17, 4) };
		sortedX = new Point[] { new Point(0, 5), new Point(1, 1), new Point(2, 3), new Point(17, 4) };
		sortedY = new Point[] { new Point(1, 1), new Point(2, 3), new Point(17, 4), new Point(0, 5) };
	}

	@Test
	void testSortX()
	{
		sorter.setComparator(0);
		sorter.sort();
		System.out.println("By X: " + Arrays.deepToString(sorter.points));
		for (int i = 0; i < sorter.points.length; ++i)
		{
			if (!sorter.points[i].equals(sortedX[i]))
				fail();
		}
	}

	@Test
	void testSortY()
	{
		sorter.setComparator(1);
		sorter.sort();
		System.out.println("By Y: " + Arrays.deepToString(sorter.points));
		for (int i = 0; i < sorter.points.length; ++i)
		{
			if (!sorter.points[i].equals(sortedY[i]))
				fail();
		}
	}
}
