package enums;

public enum Color {

  RED,
  BLUE,
  GREEN,
  UNKNOWN;

  public static Color getEnum(String value){

    for(Color color: Color.values()){

      if(color.toString().equalsIgnoreCase(value)) return color;
    }

    return Color.UNKNOWN;
  }
}
