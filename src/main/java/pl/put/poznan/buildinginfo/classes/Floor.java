package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@code Floor} class represents a floor within a building.
 * It extends the {@link Location} class and includes methods to calculate various
 * parameters such as area, volume (cube), lighting efficiency, and heating efficiency for the floor.
 */
public class Floor extends Location {

    /**
     * The list of rooms contained within the floor.
     */
    @JsonProperty("rooms")
    public List<Room> rooms;

    /**
     * Constructs a {@code Floor} with a specific ID and name.
     *
     * @param id the unique identifier of the floor
     * @param name the name of the floor
     */
    public Floor(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }

    /**
     * Constructs a {@code Floor} with default values.
     * <p>
     * This no-argument constructor is required for deserialization.
     * </p>
     */
    public Floor() {
        super(0, ""); // Calls the no-argument constructor of the parent class
        this.rooms = new ArrayList<>();
    }

    /**
     * Returns the list of rooms on the floor.
     *
     * @return the list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets the list of rooms on the floor.
     *
     * @param rooms the list of rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Calculates the total area of the floor by summing up the areas of all rooms.
     *
     * @return the total area of the floor
     */
    public float getFloorArea() {
        float floorArea = 0;
        for (Room room : rooms) {
            floorArea += room.getArea();
        }
        return floorArea;
    }

    /**
     * Calculates the total volume (cube) of the floor by summing up the volumes of all rooms.
     *
     * @return the total volume of the floor
     */
    public float getFloorCube() {
        float floorCube = 0;
        for (Room room : rooms) {
            floorCube += room.getCube();
        }
        return floorCube;
    }

    /**
     * Calculates the total lighting power of the floor by summing up the lighting power of all rooms.
     *
     * @return the total lighting power of the floor
     */
    public float getFloorLight() {
        float floorLight = 0;
        for (Room room : rooms) {
            floorLight += room.getLight();
        }
        return floorLight;
    }

    /**
     * Calculates the total heating power of the floor by summing up the heating power of all rooms.
     *
     * @return the total heating power of the floor
     */
    public float getFloorHeating() {
        float floorHeating = 0;
        for (Room room : rooms) {
            floorHeating += room.getHeating();
        }
        return floorHeating;
    }

    /**
     * Calculates the average lighting power per square meter for the floor.
     *
     * @return the average lighting power per square meter
     */
    public float getAverageFloorLight() {
        float averageFloorLight = getFloorLight() / getFloorArea();
        return averageFloorLight;
    }

    /**
     * Calculates the average heating power per cubic meter for the floor.
     *
     * @return the average heating power per cubic meter
     */
    public float getAverageFloorHeating() {
        float averageHeating = getFloorHeating() / getFloorCube();
        return averageHeating;
    }

    /**
     * Retrieves a list of rooms on the floor that exceed a specified energy consumption threshold.
     *
     * @param threshold the energy consumption threshold
     * @return a list of rooms that exceed the specified threshold
     */
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
