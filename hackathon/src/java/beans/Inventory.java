/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author vanshamaggarwal
 */
public class Inventory {

    private String productId;
    private String quantity;
    private String shopId;
    private String productName;
    private String price;

    // Default constructor
    public Inventory() {
    }

    // Parameterized constructor
    public Inventory(String productId, String quantity, String shopId, String productName, String price) {
        this.productId = productId;
        this.quantity = quantity;
        this.shopId = shopId;
        this.productName = productName;
        this.price = price;
    }

    // Getter and Setter methods for each field
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
