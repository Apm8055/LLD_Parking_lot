package serviceImpl;

import enums.Color;
import enums.VehicleType;
import java.util.List;
import models.Floor;
import models.ParkingLot;
import services.ManageParkingLot;
import java.util.*;

public class ManageParkingLotImpl implements ManageParkingLot {

  @Override
  public ParkingLot createParkingLot(String parkingLotId, int numberOfFloors, int slotsPerFloor) {

    ParkingLot parkingLot = new ParkingLot(parkingLotId, numberOfFloors, slotsPerFloor);
    return parkingLot;
  }

  @Override
  public void addFloor(ParkingLot parkingLot, int floorNo, int NumOfSlots) {

    Floor newFloor = new Floor(floorNo, NumOfSlots);
    parkingLot.addFloor(newFloor);
  }

  @Override
  public String parkVehicle(ParkingLot parkingLot, VehicleType vehicleType, String vehicleRegNum, Color color) {

    List<Floor> floors = parkingLot.getFloor();
    int size = floors.size();
    String ticket;

    for (int i = 0; i < size; i++) {

      ticket = bookFirstEmptySlotAndGetTicket(floors.get(i), vehicleType, vehicleRegNum);
      if (Objects.nonNull(ticket)) {
        return ticket;
      }
    }

    return null;
  }

  String bookFirstEmptySlotAndGetTicket(Floor floor, VehicleType vehicleType, String vehicleRegNum) {

    return "TICK123";
  }
}
