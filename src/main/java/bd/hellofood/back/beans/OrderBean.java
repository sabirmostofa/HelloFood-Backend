package bd.hellofood.back.beans;

import java.util.ArrayList;

import com.google.cloud.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBean {

    private String id;
    private Timestamp timestamp;
    private String username;
    private String userEmail;
    private String userAddress;
    private String userPhone;
    private String zoneName;
    private String areaName;
    private int totalPrice;
    private int deliveryCharge;
    private int extraDeliveryCharge;
    private ArrayList<OrderItemBean> orders;

    @Override
    public String toString() {
    	return "user: " + username + "  email: " + userEmail + " price: "+ totalPrice;
    }
}
