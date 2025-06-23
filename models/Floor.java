package models;

import java.util.ArrayList;
import java.util.List;

public class Floor {

  int floorNo;
  int maxSlotLimit;
  List<Slot> slots = new ArrayList<>();

  public Floor(int floorNo, int slots) {
    this.floorNo = floorNo;
    this.maxSlotLimit = 100; // setting a default value
    for (int i = 1; i <= slots; i++) {
      this.slots.add(new Slot(i));
    }
  }

  @Override
  public String toString() {

    String Object = "FloorNo: " + this.floorNo + "\n";
    Object += "Slots:\n";

    for(int i=0;i<this.slots.size(); i++){
      Object += this.slots.get(i).toString() + "\n";
    }

    return Object;
  }
}
