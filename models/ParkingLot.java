package models;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot {

  private String Id;
  private List<Floor> floors = new ArrayList<>();

  public ParkingLot(String Id, int floors, int slotsPerFloor) {
    this.Id = Id;
    for (int i = 1; i <= floors; i++){
      this.floors.add(new Floor(i,slotsPerFloor));
    }
  }

  public List<Floor> getFloor(){
    return this.floors;
  }

  public String getId(){
    return this.Id;
  }

  public void addFloor(Floor floor){
    this.floors.add(floor);
  }

  @Override
  public String toString(){

    String object = "Id: " + this.Id + "\n";
    object += "Floors:\n";

    for(int i=0;i<this.floors.size();i++){

      object += this.floors.get(i).toString() + "\n";
    }

    return object;
  }
}
