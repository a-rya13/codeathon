package beans;

public class Shop {

    private String shopId;
    private String shopName;
    private String ownerName;
    private String contactInfo;
    private String pass;

    // Default constructor
    public Shop() {
    }

    // Parameterized constructor
    public Shop(String shopId, String shopName, String ownerName, String contactInfo,String pass) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.pass = pass;
    }

    // Getter and Setter methods for each field
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
