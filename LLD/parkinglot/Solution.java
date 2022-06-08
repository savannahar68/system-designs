// This is a sandbox environment that allows you to experiment with CoderPad's execution capabilities.
// It's a temporary throw-away session only visible to you so you can test out the programming environment.
// Once you select a language, to execute your code simply hit the 'Run' button which will be located in the
// top left hand of your screen.
//
// To see more information about the language you have selected, hit the 'Info' button beside the language dropdown.
// You'll find what version of the language is running and the packages available for the given language.

/*
 * Click `Run` to execute the snippet below!
 */

import static org.junit.Assert.assertArrayEquals;

import java.io.*;
import java.time.Instant;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;


/*

Objective :
Don't focus on Algo/ DS but foucs on writing clean and maintainable code

Requirements / Clarification questions :

1. Has multiple floors
2. Multiple entrance and exit => Synchonization aspect
3. Can we always expect the Owners of Vehicle to park at the spot mentioned in the ticket
4. Parking strategy to be implemented
5. Pricing strategy 
6. Payment part can be excluded for now 


Entitines of the systme :

Flow -> ParkingLot -> List<ParkingFloor> -> List<ParkingSlot> -> Vehicle

1. ParkingLot
2. ParkingFloor
3. ParkingSlot
4. Vehicle
5. ParkingTicket 
6. Payment 

Apis / Interfaces 

1. ParkingLotService => ParkingLotDao , ParkingLotStrategy, ParkingLotPricing

Platform 

2. ParkingLotDao
3. ParkingLotStrategy
4. ParkingLotPricingInterface

Factory

ParkingLotFactory => Configration
ParkingLotDaoFactory => Configration 

Exception 

Proxies

*/

// Enums

enum VehicleType {
  MOTOR_BIKE(1),
  CAR(2),
  VAN(3),
  UNKNWON(0);

  private final Integer numberOfSlot;

  public VehicleType(Integer slot) {
      this.numberOfSlot = slot;
  }
}


enum ParkingSlotType {
  SMALL,
  COMPACT,
  LARGE;
}

enum ParkingSlotStatus {
  AVAILABLE,
  RESERVED;
}

// Domains 

class Vehicle {
  String numberPlate;
  VehicleType vehicleType;
  List<ParkingSlot> listOfParkingSlot;
  ParkingTicket parkingTicket;

  public Vehicle(String numberPlate, VehicleType type) {
    this.numberPlate = numberPlate;
    this.vehicleType = type;
    listOfParkingSlot = null;
    parkingTicket = null;
  }

  public VehicleType getVehicleType() { return vehicleType; }
  public void setParkingSlot(List<ParkingSlot> slotList) { this.listOfParkingSlot = slotList;}
  public void setParkingTicket(ParkingTicket ticket) { this.parkingTicket =  ticket; }
  public ParkingTicket getParkingTicket() { return this.parkingTicket; }
}

class ParkingSlot {
  Integer id; // F1_001
  ParkingSlotType slotType;
  ParkingSlotStatus slotStatus;
  Vehicle vehicle;

  public ParkingSlot(Integer id, ParkingSlotType slotType) {
    this.id = id;
    this.slotType = slotType;
    this.slotStatus = ParkingSlotStatus.AVAILABLE;
    vehicle = null;
  }

  public void setSlotStatus(ParkingSlotStatus status) { this.slotStatus = status; }
  public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
  public Vehicle getVehicle() { return this.vehicle; }
  public ParkingSlotStatus getParkingSlotStatus() { return slotStatus; }
  public ParkingSlotType getParkingSlotType() { return slotType; }
}

class ParkingFloor {
  List<ParkingSlot> parkingSlots;
  Integer level;
  UUID id;
  Integer capacity;

  public ParkingFloor(Integer level, List<ParkingSlot> slots) {
    this.id = UUID.randomUUID();
    this.level = level;
    this.parkingSlots = slots;
    this.capacity = slots.size(); 
  }
}


class ParkingTicket {
  UUID id;
  Vehicle vehicle;
  List<ParkingSlot> slots;
  Double fair;
  Instant entryTime;
  Instant exitTime;

  public ParkingTicket(Vehicle vehicle, List<ParkingSlot> slots) {
    this.id = UUID.randomUUID();
    this.slots = slots;
    this.fair = 0.0;
    this.entryTime = Instant.now();
    this.exitTime = null;
  }
}

class ParkingLot {
  UUID id;
  String name;
  List<ParkingFloor> floors; // this will hold ids

  public ParkingLot(String name, List<ParkingFloor> floors) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.floors = floors;
  }
}

// Apis


interface ParkingLotService {
  // admin 
  void addParkingFloor(ParkingFloor floor); // throws ParkingLotException;
  void addParkingSlot(ParkingSlot parkingSlot); // throws ParkingLotException
  void addParkingFloorList(List<ParkingFloor> floors); // throws ParkingLotException
  void addParkingSlotList(List<ParkingSlot> slots); // throws ParkingLotException

  // Client => Entrance

  ParkingTicket parkVehicle(Vehicle vehicle); 
  Double unparkVehicle(Vehicle vehicle);
  Double unparkVehicle(ParkingTicket ticket);
  Integer totalAvailableParkingSlots();
  Integer totalAvailableParkingSlotsByVehicleType(VehicleType type);
  Integer totalCapacityOfParkingLot();
  Boolean isSpotFullForVehicleType(VehicleType type);
  List<ParkingSlot> findVehicleParkingSlot(Vehicle vehicle);
}

// Platform 

//interface ParkingLotStrategy
// interface ParkingLotPricing

// Service

class ParkingLotServiceImpl implements ParkingLotService {

  ParkingLot lot; // Dao 
  // ParkingLotStrategy
  // ParkignLotPricing
  Map<Vehicle, ParkingTicket> activeMapOfParkedVehicleToTicket;

  public ParkingLotServiceImpl(ParkingLot lot) {
    this.lot = lot;
    activeMapOfParkedVehicleToTicket = new HashMap<>();
  }

	@Override
	public void addParkingFloor(ParkingFloor floor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParkingSlot(ParkingSlot parkingSlot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParkingFloorList(List<ParkingFloor> floors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParkingSlotList(List<ParkingSlot> slots) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ParkingTicket parkVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double unparkVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double unparkVehicle(ParkingTicket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalAvailableParkingSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalAvailableParkingSlotsByVehicleType(VehicleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalCapacityOfParkingLot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSpotFullForVehicleType(VehicleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingSlot> findVehicleParkingSlot(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}

public class Solution {

  ParkingLot lot;

  public Solution() {}

  @Before
  public void init() {
    ParkingSlot slot1 = new ParkingSlot(0, ParkingSlotType.SMALL);
    ParkingSlot slot2 = new ParkingSlot(0, ParkingSlotType.SMALL);
    ParkingSlot slot3 = new ParkingSlot(0, ParkingSlotType.SMALL);
    ParkingFloor floor = new ParkingFloor(0, Arrays.asList(slot1, slot2, slot3));
    lot = new ParkingLot("AtoB", Arrays.asList(floor));
  }

  @Test
  public void testAdditionOfParkingFloor() {
    
  } 

  @Test
  public void testParkingVehicle() {
    
  } 

  @Test
  public void testUnparkOfVehicle() {
    
  } 

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
