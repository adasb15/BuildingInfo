package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;
import pl.put.poznan.buildinginfo.classes.Floor;
import pl.put.poznan.buildinginfo.classes.Room;

/**
 * The {@code MainTransformer} class is responsible for managing a collection of buildings.
 * It provides methods to add, retrieve, and search buildings, floors, and rooms by their IDs.
 */
@Component
public class MainTransformer {

    private final List<Building> buildings = new ArrayList<>();

    /**
     * Adds a new building to the collection.
     *
     * @param building the building to be added
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * Adds a new building to the collection using data from a JSON source.
     *
     * @param building the building to be added
     */
    public void addBuildingFromJson(Building building) {
        addBuilding(building);
    }

    /**
     * Retrieves all buildings in the collection.
     *
     * @return a list of all buildings
     */
    public List<Building> getAllBuildings() {
        return buildings;
    }

    /**
     * Finds a building in the collection by its ID.
     *
     * @param id the ID of the building to find
     * @return the building with the specified ID, or {@code null} if not found
     */
    public Building findBuildingById(int id) {
        return buildings.stream()
                .filter(building -> building.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds a floor in a specific building by its ID.
     *
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor to find
     * @return the floor with the specified ID, or {@code null} if not found
     */
    public Floor findFloorById(int buildingId, int floorId) {
        Building building = findBuildingById(buildingId);
        if (building != null) {
            return building.getFloors().stream()
                    .filter(floor -> floor.getId() == floorId)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Finds a room in a specific floor of a building by its ID.
     *
     * @param buildingId the ID of the building
     * @param floorId the ID of the floor
     * @param roomId the ID of the room to find
     * @return the room with the specified ID, or {@code null} if not found
     */
    public Room findRoomById(int buildingId, int floorId, int roomId) {
        Floor floor = findFloorById(buildingId, floorId);
        if (floor != null) {
            return floor.getRooms().stream()
                    .filter(room -> room.getId() == roomId)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
