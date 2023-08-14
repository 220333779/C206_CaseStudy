
//Conan
public class Order{
 private String dueDate;
 private String description;
 private int oID;
 
 
 public Order(String dueDate, String description, int oID) {
  this.dueDate=dueDate;
  this.description=description;
  this.oID=oID;
 }
 
 public String getdueDate() {
  return dueDate;
 }

 
 public String getDescription() {
  return description;
 }


 public int getoID() {
  return oID;
 }
 
 public String toString() {
     String output = String.format("%-20s %-30s %-10d", dueDate, description, oID);
     return output;
 }

 
 
}
