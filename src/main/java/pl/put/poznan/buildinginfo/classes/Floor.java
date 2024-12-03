package pl.put.poznan.buildinginfo.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Floor extends Location {
    @JsonProperty("rooms")
    public List<Room> rooms;

    /**
     * Constructor of a Floor
     *
     * @param id param id is the id of the floor
     * @param name param name is the name of the floor
     */

    public Floor(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }

    public Floor() {
        super(0, "");  // Konstruktor bezargumentowy
        this.rooms = new ArrayList<>();
    }

    // Gettery i Settery
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    //obliczanie parametrów dla piętra na podstawie danych z pomieszczeń
    public float getFloorArea() {
        float floorArea = 0;
        for (Room room : rooms) {
            floorArea += room.getArea();
        }
        return floorArea;
    }

    public float getFloorCube() {
        float floorCube = 0;
        for (Room room : rooms) {
            floorCube += room.getCube();
        }
        return floorCube;
    }

    public float getFloorLight() {
        float floorLight = 0;
        for (Room room : rooms) {
            floorLight += room.getLight();
        }
        return floorLight;
    }

    public float getFloorHeating(){
        float floorHeating =0;
        for (Room room : rooms) {
            floorHeating += room.getHeating();
        }
        return floorHeating;
    }

    public float getAverageFloorLight() {
        float averageFloorLight = getFloorLight()/getFloorArea();
        return averageFloorLight;
    }

    public float getAverageFloorHeating(){
        float averageHeating = getFloorHeating()/getFloorCube();
        return averageHeating;
    }

    public List<Room> getRoomsAboveEnergyThreshold(float threshold) {
        List<Room> roomsAboveThreshold = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAverageRoomHeating() > threshold) {
                roomsAboveThreshold.add(room);
            }
        }
        return roomsAboveThreshold;
    }
}
