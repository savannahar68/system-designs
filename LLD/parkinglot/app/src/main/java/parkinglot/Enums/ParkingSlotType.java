package parkinglot.Enums;

import java.util.List;

public enum ParkingSlotType {
    SMALL_SPOT(1),
    COMAPCT_SPOT(2),
    LARGE_SPOT(3),
    UNKNOWN(0);

    public final Integer slotsNeeded;

    private ParkingSlotType(Integer slotsNeeded) {
        this.slotsNeeded = slotsNeeded;
    }
}
