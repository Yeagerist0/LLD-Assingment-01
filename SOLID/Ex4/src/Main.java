import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        RoomPricingRegistry roomRegistry = new RoomPricingRegistry();
        roomRegistry.register(LegacyRoomTypes.SINGLE, () -> 14000.0);
        roomRegistry.register(LegacyRoomTypes.DOUBLE, () -> 15000.0);
        roomRegistry.register(LegacyRoomTypes.TRIPLE, () -> 12000.0);
        roomRegistry.register(LegacyRoomTypes.DELUXE, () -> 16000.0);

        AddOnPricing addOnPricing = new DefaultAddOnPricing();

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), roomRegistry, addOnPricing);
        calc.process(req);
    }
}
