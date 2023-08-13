//Conan
import java.util.ArrayList;

public class ParentGuardianMenu {

 public static void main(String[] args) {
  ArrayList<Order> orderList = new ArrayList<Order>();
  ArrayList<Payment> paymentList = new ArrayList<Payment>();
  orderList.add(new Order("10/8/2023", "Bento Set", 10));
  orderList.add(new Order("14/8/2023", "Maggi Mee", 20));
  Payment payment1 = new Payment("PM1", "John Stones", "Jurong Secondary School", 1000.00); 
  paymentList.add(payment1);

  int option = 0;

  while (option != 7) {

   ParentGuardianMenu.menu();
   option = Helper.readInt("Enter an option > ");

   if (option == 1) {
    // View all Orders
    ParentGuardianMenu.viewAllOrder(orderList);
   } else if (option == 2) {
    Order o1 = inputOrder();
    ParentGuardianMenu.addOrder(orderList, o1);

   } else if (option == 3) {
    // Loan item
    ParentGuardianMenu.viewAllOrder(orderList);
    int orderID = Helper.readInt("Enter order ID > ");
    ParentGuardianMenu.deleteOrder(orderList, orderID);

   } else if (option == 4) {
	   viewAllPayments(paymentList); // Removed "ParentMenu." for the same reason 
   } else if (option == 5) { 
       addPayment(paymentList); // Removed "ParentMenu." 
       System.out.println("Payment added"); 
   } else if (option == 6) { 
       String paymentIdToDelete = Helper.readString("Enter Payment ID to delete: "); 
       deletePayment(paymentList, paymentIdToDelete); // Changed method name 
   } else if (option == 7 ) {
	   System.out.println("Bye!");
   }
   else {
    System.out.println("Invalid option");
    
   }

  }

 }

 private static Order inputOrder() {
  String category = Helper.readString("Enter due date > ");
  String description = Helper.readString("Enter description > ");
  int oID = Helper.readInt("Enter order ID > ");

  Order oo = new Order(category, description, oID);
  return oo;
 }

 public static void viewAllOrder(ArrayList<Order> orderList) {
  setHeader("ORDER LIST");
  String output = String.format("%-5s %-20s %-10s %-10s\n", "No.", "DESCRIPTION", "DUE DATE", "ORDER ID");
  output += retrieveAllOrder(orderList);
  System.out.println(output);
 }

 public static void setHeader(String header) {
  System.out.println(header);
 }

 public static String retrieveAllOrder(ArrayList<Order> orderList) {
  String output = "";
  int count = 1;
  for (Order order : orderList) {
   output += String.format("%-5d %-20s %-10s %-10d\n", count, order.getDescription(), order.getdueDate(),
     order.getoID());
   count++;
  }
  return output;
 }

 public static void addOrder(ArrayList<Order> orderList, Order oo) {
  Order o;
  for (int i = 0; i < orderList.size(); i++) {
   o = orderList.get(i);
   if (o.getoID() == oo.getoID()||o.getDescription().equalsIgnoreCase(oo.getDescription())) {
    System.out.println("Duplicate ID/Description! Try again! :)");
    return;
   }
  }
  if (oo.getoID() == 0 || oo.getDescription().isEmpty()) {
   System.out.println("Empty Description/Invalid ID is entered! Try again! :) ");
   return;
  }
  orderList.add(oo);
 }

 public static void deleteOrder(ArrayList<Order> orderList, int orderId) {
  Order orderToDelete = null;
  for (Order order : orderList) {
   if (order.getoID() == orderId) {
    orderToDelete = order;
    break;
   }
  }

  if (orderToDelete != null) {
   orderList.remove(orderToDelete);
   System.out.println("Order deleted successfully!");
  } else {
   System.out.println("Order with the specified ID not found!");
  }
 }
 //Yu Bin
 public static String retrieveAllPayments(ArrayList<Payment> paymentList) { 
     String output = ""; 
     // write your code here 
     for (int i = 0; i < paymentList.size(); i++) { 
         output += String.format("%-10s %-20s %-30s %-10.2f \n", 
             paymentList.get(i).getPaymentID(), 
             paymentList.get(i).getName(), 
             paymentList.get(i).getSchName(), 
             paymentList.get(i).getTotalAmt()); 
     } 
     return output; 
 } 

 public static void viewAllPayments(ArrayList<Payment> paymentList) { 
     setHeader("PAYMENT LIST"); 
     String output = String.format("%-10s %-20s %-30s %-10s \n", "Payment ID", "Parent Name", "School Name", "Payment Amount"); 
     output += retrieveAllPayments(paymentList); 
     System.out.println(output); 
 } 

 public static void addPayment(ArrayList<Payment> paymentList) { 
     // Read the input for the new payment 
     String paymentId = Helper.readString("Enter Payment ID: "); 
     String name = Helper.readString("Enter Parent Name: "); 
     String schName = Helper.readString("Enter School Name: "); 
     double totalAmt = Helper.readDouble("Enter Total Payment: "); // Changed to readDouble 

     // Create a new Payment object 
     Payment newPayment = new Payment(paymentId, name, schName, totalAmt); 
     paymentList.add(newPayment); // Moved inside the method 
     System.out.println("Payment added successfully."); 
 } 

 public static void deletePayment(ArrayList<Payment> paymentList, String paymentIdToDelete) { 
     Payment paymentToDelete = null; // Changed variable name to follow naming convention 

     // Find the payment with the specified payment ID 
     for (Payment payment : paymentList) { 
         if (payment.getPaymentID().equals(paymentIdToDelete)) { 
             paymentToDelete = payment; 
             break; 
         } 
     } 

     // If the payment is found, remove it from the list 
     if (paymentToDelete != null) { 
         paymentList.remove(paymentToDelete); 
         System.out.println("Payment deleted successfully."); 
     } else { 
         System.out.println("Payment with the specified ID not found."); 
     } 
 } 

 public static void menu() {
  ParentGuardianMenu.setHeader("ORDER LIST");
  System.out.println("1. Display Order");
  System.out.println("2. Add order");
  System.out.println("3. Delete order");
  System.out.println("4. Show payment"); 
  System.out.println("5. Add payment"); 
  System.out.println("6. Delete payment"); 
  System.out.println("7. Quit");
  Helper.line(80, "-");

 }
}
