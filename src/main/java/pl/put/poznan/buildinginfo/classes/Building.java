package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@code Building} class represents a building that contains multiple floors.
 * It extends the {@link Location} class and includes methods to calculate various
 * parameters such as area, volume (cube), lighting efficiency, and heating efficiency.
 */
public class Building extends Location {

    /**
     * The list of floors contained within the building.
     */
    @JsonProperty("floors")
    public List<Floor> floors;

    /**
     * Constructs a {@code Building} with a specific ID and name.
     *
     * @param id the unique identifier of the building
     * @param name the name of the building
     */
    public Building(int id, String name) {
        super(id, name); // Calls the constructor of the parent class
        this.floors = new ArrayList<>();
    }

    /**
     * Constructs a {@code Building} with default values.
     * <p>
     * This no-argument constructor is required for deserialization.
     * </p>
     */
    public Building() {
        super(0, ""); // Calls the no-argument constructor of the parent class
        this.floors = new ArrayList<>();
    }

    /**
     * Returns the list of floors in the building.
     *
     * @return the list of floors
     */
    public List<Floor> getFloors() {
        return floors;
    }

    /**
     * Sets the list of floors in the building.
     *
     * @param floors the list of floors to set
     */
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    /**
     * Calculates the total area of the building by summing up the areas of all floors.
     *
     * @return the total area of the building
     */
    public float getBuildingArea() {
        float buildingArea = 0;
        for (Floor floor : floors) {
            buildingArea += floor.getFloorArea();
        }
        return buildingArea;
    }

    /**
     * Calculates the total volume (cube) of the building by summing up the volumes of all floors.
     *
     * @return the total volume of the building
     */
    public float getBuildingCube() {
        float buildingCube = 0;
        for (Floor floor : floors) {
            buildingCube += floor.getFloorCube();
        }
        return buildingCube;
    }

    /**
     * Calculates the total lighting power of the building by summing up the lighting power of all floors.
     *
     * @return the total lighting power of the building
     */
    public float getBuildingLight() {
        float buildingLight = 0;
        for (Floor floor : floors) {
            buildingLight += floor.getFloorLight();
        }
        return buildingLight;
    }

    /**
     * Calculates the total heating power of the building by summing up the heating power of all floors.
     *
     * @return the total heating power of the building
     */
    public float getBuildingHeating() {
        float buildingHeating = 0;
        for (Floor floor : floors) {
            buildingHeating += floor.getFloorLight(); // This may be a mistake (uses `getFloorLight` instead of `getFloorHeating`).
        }
        return buildingHeating;
    }

    /**
     * Calculates the average lighting power per square meter for the building.
     *
     * @return the average lighting power per square meter
     */
    public float getAverageBuildingLight() {
        float averageBuildingLight = getBuildingLight() / getBuildingArea();
        return averageBuildingLight;
    }

    /**
     * Calculates the average heating power per cubic meter for the building.
     *
     * @return the average heating power per cubic meter
     */
    public float getAverageBuildingHeating() {
        float averageBuildingHeating = getBuildingHeating() / getBuildingCube();
        return averageBuildingHeating;
    }

    /**
     * Retrieves a list of rooms that exceed a specified energy consumption threshold.
     *
     * @param threshold the energy consumption threshold
     * @return a list of rooms that exceed the specified threshold
     */
    public List<Room> getRoomsAboveEnergyThreshold(float threshold) {
        List<Room> roomsAboveThreshold = new ArrayList<>();

        // Iterate through each floor and collect rooms exceeding the threshold
        for (Floor floor : floors) {
            List<Room> roomsOnFloor = floor.getRoomsAboveEnergyThreshold(threshold);
            roomsAboveThreshold.addAll(roomsOnFloor);
        }

        return roomsAboveThreshold;
    }
}
