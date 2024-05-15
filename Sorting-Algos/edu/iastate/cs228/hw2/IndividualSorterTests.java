package edu.iastate.cs228.hw2;

/**
 * 
 * @author - Hrishikesha Kyathsandra
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndividualSorterTests extends AbstractSorterTests
{
	@BeforeEach
	void setUp()
	{
		super.setUp();
		sorter = new QuickSorter(pts); // swap sorter names and test any you want
	}
}
