//Conan
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParentGuardianMenuTest {
 
 private Order o1;
 private Order o2;
 private Order o3;
 private ArrayList<Order> orderList;

 public ParentGuardianMenuTest() {
  super();
 }

 @Before
 public void setUp() throws Exception {
  o1 = new Order("10/8/2023", "Bento Set", 10);
  o2 = new Order("14/8/2023","Maggi Mee", 20);
  o3 = new Order("","",0);
  orderList = new ArrayList<Order>();
 }

 @Test
 public void testAddOrder() {
  // Order list is not null and is empty, so that can add a new Order
  assertNotNull("Test if there is valid Order arraylist to add to", orderList);
  assertEquals("Test that the order arrayList is empty.", 0, orderList.size());

  // Use the static method from the main class to add orders - normal
  ParentGuardianMenu.addOrder(orderList, o1);
  assertEquals("Test that Order arraylist size is 1", 1, orderList.size());
  assertSame("Test that Order is added", o1, orderList.get(0));

  // Add another order. Test the size of the list is 2? - boundary
  // The order just added is as same as the second order of the list
  ParentGuardianMenu.addOrder(orderList, o2);
  assertEquals("Test that Order arraylist size is 2", 2, orderList.size());
  assertSame("Test that Order is added", o2, orderList.get(1));
  
  //Test that it is not possible to add an invalid ID - error
  ParentGuardianMenu.addOrder(orderList, o3);
  assertEquals("Test that Order arraylist size is 2", 2, orderList.size());
  
 }
 
 @Test
 public void testRetrieveAllOrder() {
  // Test if Order list is not null but empty 
  assertNotNull("Test if there is valid order arraylist to retrieve item from", orderList);
    
  //test if the list of order retrieved from the orderList is empty - normal
  String allOrder= ParentGuardianMenu.retrieveAllOrder(orderList);
  String testOutput = "";
  assertEquals("Test that the retrieved orderlist is empty?", testOutput, allOrder);
    
  //Given an empty list, after adding 2 orders, test if the size of the list is 2 - boundary
  ParentGuardianMenu.addOrder(orderList, o1);
  ParentGuardianMenu.addOrder(orderList, o2);
  assertEquals("Test that order arraylist size is 2", 2, orderList.size());
    
  //test if the expected output string same as the list of orders retrieved from the CaseStudy - error 
  allOrder= ParentGuardianMenu.retrieveAllOrder(orderList);
  testOutput = String.format("%-5s %-20s %-10s %-10d\n", "1 ","Bento Set", "10/8/2023", 10);
  testOutput += String.format("%-5s %-20s %-10s %-10d\n","2 ", "Maggi Mee", "14/8/2023", 20); 
  assertEquals("Test that ViewAllorderlist", testOutput, allOrder);
 }
 
 @Test
 public void testDeleteOrder() {
  //Test case 1
  //Delete an existing order - normal
  assertNotNull("Test if there is valid order arraylist to delete from", orderList);
  ParentGuardianMenu.addOrder(orderList, o1);
  ParentGuardianMenu.addOrder(orderList, o2);
  assertEquals("Test that the order arraylist size is 2.", 2, orderList.size());
  //Given a order list with 2 item, after deleting the order, the size of the list is 1.
  ParentGuardianMenu.deleteOrder(orderList, 10);
  assertEquals("Test that the order arraylist size is 1.", 1, orderList.size());
    
  //Test case 2
  //Delete non-existent order - error condition
  ParentGuardianMenu.deleteOrder(orderList, 30);
  //Test that you cannot delete a order that does not exist
  assertEquals("Test that orderList size is empty after trying to delete non-existent order"
    , 1, orderList.size());
  
  //Test case 3
  //Delete last order in the list - boundary 
  assertEquals("Test that the order arraylist size is 1.", 1, orderList.size());
  //Given a order list with 1 item, after deleting the order, the size of the list is empty.
  ParentGuardianMenu.deleteOrder(orderList, 20);
  assertEquals("Test that the order arraylist size is 0.", 0, orderList.size());
 }

 @After
 public void tearDown() throws Exception {
  o1 = null;
  orderList = null;
 }
}