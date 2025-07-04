package models;

import enums.VehicleType;

public class Slot {
  private int slotNo;
  private boolean occupied; // default value is false
  private VehicleType vehicleType;
  private String VehicleRegNo;

  Slot(int slotNo, VehicleType vehicleType) {
    this.slotNo = slotNo;
    this.vehicleType = vehicleType;
  }

  Slot(int slotNo) {
    this.slotNo = slotNo;
    this.vehicleType = VehicleType.DEFAULT;
  }

  public boolean isOccupied(){
    return this.occupied;
  }

  public void setOccupied(){
    this.occupied = true;
  }

  public void setUnOccupied(){
    this.occupied = false;
  }

  public int getSlotNo(){
    return this.slotNo;
  }

  @Override
  public String toString() {

    String object = "slotNo: " + this.slotNo + "\n";
    object += "vehicleType: " + this.vehicleType + "\n";
    object += "Occupied: " + this.occupied + "\n";
    if(this.occupied){
      object += "VehicleRegNo: " + this.VehicleRegNo + "\n";
    }

    return object;
  }
}
