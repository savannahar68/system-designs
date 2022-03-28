package parkinglot.Domain.Vehicles;

import parkinglot.Enums.VehicleType;

public class Car extends Vehicle {

    public Car(String registrionNumber) {
        super(registrionNumber, VehicleType.CAR);
    }
}
