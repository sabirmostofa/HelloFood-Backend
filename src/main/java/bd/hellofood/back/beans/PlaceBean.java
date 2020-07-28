package bd.hellofood.back.beans;

import com.google.firebase.internal.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceBean {

    private int maxRestaurants;
    private int deliveryCharge;
    private int extraDeliveryCharge;
    private int deliveryThreshold;
    private int additionalDeliveryThreshold;
    private String hotLine;
    private String orderEmail;
    private String orderEmailPass;
    private String homeImage;
    private String areaManagerEmail;
    private double longitude;
    private double latitude;


    public PlaceBean(int maxRestaurants, int deliveryCharge, int extraDeliveryCharge,
                     int deliveryThreshold, int additionalDeliveryThreshold) {
        this.deliveryCharge = deliveryCharge;
        this.extraDeliveryCharge = extraDeliveryCharge;
        this.deliveryThreshold = deliveryThreshold;
        this.additionalDeliveryThreshold = additionalDeliveryThreshold;
        this.maxRestaurants = maxRestaurants;
    }

    public PlaceBean(String hotLine, String orderEmail, String orderEmailPass, String areaMail) {
        this.orderEmail = orderEmail;
        this.orderEmailPass = orderEmailPass;
        this.hotLine = hotLine;
        this.areaManagerEmail = areaMail;
    }


    @NonNull
    @Override
    public String toString() {
        return "maxRestaurants: " + getMaxRestaurants() + " deliveryCharge: " + getDeliveryCharge()
                + " extraDeliveryCharge: " + getExtraDeliveryCharge() +
                " deliveryThreshold: " + getDeliveryThreshold() +
                " additionalDeliveryThreshold: " + getAdditionalDeliveryThreshold();
    }
}