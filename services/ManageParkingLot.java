package services;

import enums.Color;
import enums.VehicleType;
import models.ParkingLot;

public interface ManageParkingLot {

  ParkingLot createParkingLot(String parkingLotId, int numberOfFloors, int slotsPerFloor);
  void addFloor(ParkingLot parkingLot, int floorNo, int NumOfSlots);
  String parkVehicle(ParkingLot parkingLot, VehicleType vehicleType, String VehicleRegNum, Color color);
}
