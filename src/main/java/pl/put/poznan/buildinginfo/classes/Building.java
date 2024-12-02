package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;


public class Building extends Location {

    public List<Floor> floors;

    public Building(int id, String name) {
      super(id, name); //tzn ze z klasy nadrzednej
      this.floors = new ArrayList<>();
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
