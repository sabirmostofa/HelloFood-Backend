package bd.hellofood.back.beans;

import java.util.ArrayList;

import com.google.cloud.Timestamp;

public class OrderBean {



    private Timestamp timestamp;

    private ArrayList<OrderItemBean>  orders ;

    private String username;
    private String userEmail;
    private String userAddress;
    private String userPhone;

    private int totalPrice;

    private  int deliveryCharge;

    private int extraDeliveryCharge;

    private  String zoneName;
    private String areaName;

    public OrderBean(){

    }

    public OrderBean(Timestamp timestamp, ArrayList<OrderItemBean> orders, String username,
                     String userEmail, String userAddress, String userPhone, int totalPrice,
                     String areaName, String zoneName, int delivery, int extradelivery) {
        this.timestamp = timestamp;
        this.orders = orders;
        this.username = username;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.totalPrice = totalPrice;
        this.areaName = areaName;
        this.zoneName = zoneName;
        this.deliveryCharge = delivery;
        this.extraDeliveryCharge = extradelivery;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<OrderItemBean> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<OrderItemBean> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public int getExtraDeliveryCharge() {
        return extraDeliveryCharge;
    }

    public void setExtraDeliveryCharge(int extraDeliveryCharge) {
        this.extraDeliveryCharge = extraDeliveryCharge;
    }
    
    public String toString() {
    	
    	return "user: " + username + "  email: " + userEmail + " price: "+ totalPrice;
    }



}
