package beans;
public class Employee {
    
    private String empId;
    private String name;
    private String age;
    private String role;
    private String shopId;
    private String contactNo;
    private String salary;
    private String address;

    public Employee() {}

    public Employee(String empId, String name, String age, String role, String shopId, String contactNo, String salary, String address) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.role = role;
        this.shopId = shopId;
        this.contactNo = contactNo;
        this.salary = salary;
        this.address = address;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
}
