package beans;

public class Customer {

    private String customerId;
    private String name;
    private String contactNo;
    private String email;
    private String password;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(String customerId, String name, String contactNo, String email, String password) {
        this.customerId = customerId;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter methods for each field

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString() method to print Customer object details
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", contactNo=" + contactNo 
                + ", email=" + email + ", password=" + password + "]";
    }
}