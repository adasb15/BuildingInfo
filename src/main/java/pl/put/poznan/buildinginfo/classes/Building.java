package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;


public class Building extends Location {

    public List<Floor> floors;

    public Building(int id, String name) {
      super(id, name); //tzn ze z klasy nadrzednej
      this.floors = new ArrayList<>();
  }

  //gettery tutaj bedą miały za zadanie sumowac i wyliczać
  // powierzchnie, kubature, oswietlenie i ogrzewanie w całym budynku
}
