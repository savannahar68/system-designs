package parkinglot.Strategy;

import parkinglot.Domain.ParkingTicket;
import parkinglot.Interface.PricingStrategy;

public class PricingStrategyImpl implements PricingStrategy {
    @Override
    public Double getPrice(ParkingTicket ticket) {
        return ticket.getTotalParkingTime() * 10.0;
    }
}
