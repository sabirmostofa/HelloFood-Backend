package bd.hellofood.back.beans;

import com.google.firestore.v1.StructuredQuery;

public class OrderItemBean {

    private  String itemName;

    private  String restaurantName;
    private  int itemQuantity;
    private  int itemPrice;



    private String restaurantKey;
    private String itemKey;

    // default constructor used by firebase to retrieve data
    public OrderItemBean(){

    }

    public OrderItemBean(String itemName, String restaurantName, int itemQuantity, int itemPrice) {
        this.itemName = itemName;
        this.restaurantName = restaurantName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public OrderItemBean(String itemName, String restaurantName, int itemQuantity, int itemPrice, String restaurantKey, String itemKey) {
        this.itemName = itemName;
        this.restaurantName = restaurantName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.restaurantKey = restaurantKey;
        this.itemKey = itemKey;
    }

    public String getRestaurantKey() {
        return restaurantKey;
    }

    public void setRestaurantKey(String restaurantKey) {
        this.restaurantKey = restaurantKey;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


}
