package parkinglot.Domain.Vehicles;

import parkinglot.Enums.VehicleType;

public class MotorCycle extends Vehicle {

    public MotorCycle(String registrionNumber) {
        super(registrionNumber, VehicleType.MOTORCYCLE);
    }
}
