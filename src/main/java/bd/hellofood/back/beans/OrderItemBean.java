package bd.hellofood.back.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemBean {

    private String itemName;
    private String restaurantName;
    private String restaurantKey;
    private String itemKey;
    private int itemQuantity;
    private int itemPrice;

    @Override
    public String toString() {
        return String.format("name: %s, quantity: %d, unit price: %d",
                this.itemName,
                this.itemQuantity,
                this.itemPrice);
    }
}
