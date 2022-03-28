package parkinglot.Domain.Vehicles;

import parkinglot.Enums.VehicleType;

public class Van extends Vehicle {

    public Van(String registrionNumber) {
        super(registrionNumber, VehicleType.VAN);
    }
}
