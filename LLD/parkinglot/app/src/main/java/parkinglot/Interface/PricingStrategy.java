package parkinglot.Interface;

import parkinglot.Domain.ParkingTicket;

public interface PricingStrategy {
    Double getPrice(ParkingTicket ticket);
}
