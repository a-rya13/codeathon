/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

public class Order {

    private String orderId;
    private String shopId;
    private String productId;
    private String totalPrice;
    private String orderDate;
    private String quantity;
    private String customerId;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String orderId, String shopId, String productId, String totalPrice, String orderDate, String quantity, String customerId) {
        this.orderId = orderId;
        this.shopId = shopId;
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    // Getter and Setter methods for each field
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // toString() method to print Order object details
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", shopId=" + shopId + ", productId=" + productId
                + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", quantity=" + quantity
                + ", customerId=" + customerId + "]";
    }
}
