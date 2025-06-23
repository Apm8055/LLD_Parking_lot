import enums.Color;
import enums.VehicleType;
import java.util.*;
import models.ParkingLot;
import services.ManageParkingLot;
import services.impl.ManageParkingLotImpl;

public class Main {

  private static final ManageParkingLot manageParkingLot = new ManageParkingLotImpl();

  public static void main(String[] args) {
    System.out.println("Let's Begin, give commands");

    inputUserCommands();
  }

  public static void inputUserCommands() {
    Scanner sc = new Scanner(System.in);
    String command = sc.nextLine();
    ParkingLot parkingLot = null;

    while (!command.equalsIgnoreCase("exit")) {

      if (Objects.isNull(parkingLot)) {
        parkingLot = createParkingLot(command);
        System.out.println("Parking Lot Created with given details.");
      } else {
        processUserCommands(command, parkingLot);
      }

      command = sc.nextLine();
    }

    System.out.println("Parking Lot Closed for the Day.");
  }

  public static ParkingLot createParkingLot(String command) {

    String[] commands = command.split(" ");
    if (!Objects.equals(commands[0], "create_parking_lot")) {
      System.out.println("Invalid command");
    }

    return manageParkingLot.createParkingLot(commands[1], Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
  }

  public static void processUserCommands(String command, ParkingLot parkingLot) {

    String[] commands = command.split(" ");
    switch (commands[0]) {

      case "show_parking_lot":
        System.out.println(parkingLot);
        break;

      case "add_floor":
        manageParkingLot.addFloor(parkingLot, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        System.out.println("Added the floor with given details.");
        break;

      case "park_vehicle":
        String ticketId = manageParkingLot.parkVehicle(parkingLot, VehicleType.getEnum(commands[1]), commands[2],
              Color.getEnum(commands[3]));

        if (Objects.isNull(ticketId)) {
          System.out.println("Couldn't park the vehicle");
        } else {
          System.out.println("Parked the vehicle, TicketId: " + ticketId);
        }
        break;

      case "unpark_vehicle":



      default:
        System.out.println("Invalid Command");
    }
  }
}

// create_parking_lot PR12 1 2
// show_parking_lot
// add_floor 2 2
// park_vehicle car Reg123 Red



