package parkinglot.Domain;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class ParkingTicket {
    UUID id;
    ParkingSlot slot;
    Instant entryTime;
    Instant exitTime;
    Double fair;

    public ParkingTicket(ParkingSlot slot) {
        this.id = UUID.randomUUID();
        this.slot = slot;
        this.entryTime = Instant.now();
        this.exitTime = null;
        this.fair = 0.0;
    }

    public UUID getId() {
        return id;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setFair(Double fair) {
        this.fair = fair;
    }

    public Double getFair() {
        return fair;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public Integer getTotalParkingTime() {
        return Math.max(Math.toIntExact((Duration.between(this.entryTime, this.entryTime).abs().getSeconds() / (60 * 60))), 1);
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id=" + id +
                ", slot=" + slot +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", fair=" + fair +
                '}';
    }
}
