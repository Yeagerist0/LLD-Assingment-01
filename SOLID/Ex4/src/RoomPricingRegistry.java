import java.util.*;

public class RoomPricingRegistry {
    private final Map<Integer, RoomPricing> pricingMap = new HashMap<>();

    public void register(int roomType, RoomPricing pricing) {
        pricingMap.put(roomType, pricing);
    }

    public double getBasePrice(int roomType) {
        RoomPricing pricing = pricingMap.get(roomType);
        if (pricing != null) {
            return pricing.basePrice();
        }
        return 16000.0; // default
    }
}
