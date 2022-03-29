package parkinglot.Domain;

import java.util.UUID;

public class Payment {
    UUID id;
    Double amount;
    ParkingTicket parkingTicket;

    public Payment(Double amount, ParkingTicket parkingTicket) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.parkingTicket = parkingTicket;
    }

    public UUID getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", parkingTicket=" + parkingTicket +
                '}';
    }
}
