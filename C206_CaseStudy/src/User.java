//zen yue
public class User {
    public static final String Type = null;
  private String username;
    private String password;
    private String fullName;
    private int phoneNumber;

    public User(String username, String password, String fullName, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Username: " + username + "\n" +
                "Full Name: " + fullName + "\n" +
                "Phone Number: " + phoneNumber;
    }
}