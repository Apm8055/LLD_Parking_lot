package services.impl;

import enums.Color;
import enums.VehicleType;
import java.util.List;
import models.Floor;
import models.ParkingLot;
import models.Slot;
import services.ManageParkingLot;

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

    List<Floor> floors = parkingLot.getFloors();
    int size = floors.size();
    int slotNo = -1;

    for (int i = 0; i < size; i++) {

      slotNo = bookFirstEmptySlot(floors.get(i), vehicleType, vehicleRegNum);
      if (slotNo != -1) {
        return getParkingTicket(parkingLot.getId(), i+1, slotNo);
      }
    }

    return null;
  }

  private String getParkingTicket(String parkingLotId, int floorNo, int slotNo) {
    return parkingLotId + "_" + floorNo + "_" + slotNo;
  }

  private int bookFirstEmptySlot(Floor floor, VehicleType vehicleType, String vehicleRegNum) {

    List<Slot> slots = floor.getSlots();
    for (Slot slot : slots) {

      if (!slot.isOccupied()) {
        slot.setOccupied();
        return slot.getSlotNo();
      }
    }

    return -1;
  }

  @Override
  public void unParkVehicle(ParkingLot parkingLot, String ticket){

    String[] ticket_splitted = ticket.split("_");
    int floorNo = Integer.parseInt(ticket_splitted[1]);
    int slotNo = Integer.parseInt(ticket_splitted[2]);

    parkingLot.getFloors().get(floorNo-1).getSlots().get(slotNo-1).setUnOccupied();
  }
}
