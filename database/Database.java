package database;

import java.util.HashMap;
import java.util.Objects;
import models.Vehicle;

public class Database {

  private Database() {
  }

  private static Database db;

  HashMap<String, Vehicle> vehicleDetails = new HashMap<>();

  public static Database getInstance() {

    if (Objects.isNull(db)) {
      db = new Database();
    }

    return db;
  }
}
