package enums;

public enum VehicleType {
  CAR,
  BIKE,
  CYCLE,
  DEFAULT;

  public static VehicleType getEnum(String value){

    for(VehicleType type: VehicleType.values()){

      if(type.toString().equalsIgnoreCase(value)) return type;
    }

    return VehicleType.DEFAULT;
  }
}
