package edu.iastate.cs228.hw2;

/**
 * 
 * @author - Hrishikesha Kyathsandra.
 *
 */

import java.util.Comparator;

public class PointComparator implements Comparator<Point>
{
	@Override
	public int compare(Point o1, Point o2)
	{
		return o1.compareTo(o2);
	}
}
