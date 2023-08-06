import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Order o1;
	private Order o2;
	private ArrayList<Order> orderList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		o1 = new Order("A1", "Bento Set", 10);
		o2 = new Order("B1","Maggi Mee", 20);
		orderList = new ArrayList<Order>();
	}

	@After
	public void tearDown() throws Exception {
		o1 = null;
		orderList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddOrder() {
		// Order list is not null, so that can add a new Order - boundary
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);

		// Given an empty list, after adding 1 Order, the size of the list is 1 - normal
		// The order just added is as same as the first order of the list
		C206_CaseStudyTest.addOrder(orderList, o1);
		assertEquals("Test that Order arraylist size is 1", 1, orderList.size());
		assertSame("Test that Order is added", o1, orderList.get(0));

		// Add another order. test The size of the list is 2? - normal
		// The order just added is as same as the second order of the list
		C206_CaseStudyTest.addOrder(orderList, o2);
		assertEquals("Test that Order arraylist size is 2", 2, orderList.size());
		assertSame("Test that Order is added", o2, orderList.get(1));
	}

	private static void addOrder(ArrayList<Order> orderList2, Order o12) {
		// TODO Auto-generated method stub
		
	}

}
