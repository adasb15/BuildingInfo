package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Building extends Location {
    @JsonProperty("floors")

    public List<Floor> floors;


    public Building(int id, String name) {
      super(id, name); //tzn ze z klasy nadrzednej
      this.floors = new ArrayList<>();
  }
    public Building() {
        super(0, "");  // Konstruktor bezargumentowy, wymagany do deserializacji
        this.floors = new ArrayList<>();
    }

    // Gettery i Settery
    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    //obliczanie parametrów dla piętra na podstawie danych z pomieszczeń
    public float getBuildingArea() {
        float buildingArea = 0;
        for (Floor floor : floors) {
            buildingArea += floor.getFloorArea();
        }
        return buildingArea;
    }

    public float getBuildingCube() {
        float buildingCube = 0;
        for (Floor floor : floors) {
            buildingCube += floor.getFloorCube();
        }
        return buildingCube;
    }

    public float getBuildingLight(){
        float buildingLight = 0;
        for (Floor floor : floors) {
            buildingLight += floor.getFloorLight();
        }
        return buildingLight;
    }

    public float getBuildingHeating(){
        float buildingHeating = 0;
        for (Floor floor : floors) {
            buildingHeating += floor.getFloorLight();
        }
        return buildingHeating;
    }

    public float getAverageBuildingLight() {
        float averageBuildingLight = getBuildingLight()/getBuildingArea();
        return averageBuildingLight;
    }

    public float getAverageBuildingHeating(){
        float averageBuildingHeating = getBuildingHeating()/getBuildingCube();
        return averageBuildingHeating;
    }

    //lista pomieszczeń które przekraczaja określony poziom zużycia energii cieplnej
    public List<Room> getRoomsAboveEnergyThreshold(float threshold) {
        List<Room> roomsAboveThreshold = new ArrayList<>();

        // Dla każdego piętra, pobieramy pokoje przekraczające próg
        for (Floor floor : floors) {
            List<Room> roomsOnFloor = floor.getRoomsAboveEnergyThreshold(threshold);
            roomsAboveThreshold.addAll(roomsOnFloor);
        }

        return roomsAboveThreshold;
    }
}
