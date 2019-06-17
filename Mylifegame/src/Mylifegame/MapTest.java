package Mylifegame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	private static Map map = new Map();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNeighborsCount() {
		assertEquals(0,map.neighborsCount(0, 0));
		assertEquals(3,map.neighborsCount(2, 2));
		assertEquals(4,map.neighborsCount(3, 2));
		assertEquals(0,map.neighborsCount(8, 7));
	}
}
