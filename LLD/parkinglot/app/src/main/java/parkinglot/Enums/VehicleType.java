package parkinglot.Enums;

public enum VehicleType {
    MOTORCYCLE(1),
    CAR(2),
    VAN(3),
    UNKNOWN(0);

    public final Integer slotsNeeded;

    private VehicleType(Integer slotsNeeded) {
        this.slotsNeeded = slotsNeeded;
    }
}
