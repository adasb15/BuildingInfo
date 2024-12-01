package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;


public class Building extends Location {

    public List<Floor> floors;

    public Building(int id, String name) {
      super(id, name);
      this.floors = new ArrayList<>();
  }
}
