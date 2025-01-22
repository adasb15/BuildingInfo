package pl.put.poznan.buildinginfo.logic;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Room;

/**
 * This class is responsible for transforming room data, 
 * including calculating various parameters such as area, cube, 
 * light levels, and heating costs for a specific room in a building.
 */
@Component
public class RoomTransformer {
    
    private final MainTransformer mainTransformer;

    /**
     * Constructor that initializes the RoomTransformer with a MainTransformer.
     * 
     * @param mainTransformer The MainTransformer instance used to fetch room data.
     */
    public RoomTransformer(MainTransformer mainTransformer) {
        this.mainTransformer = mainTransformer;
    }

    /**
     * Returns the area of the room.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param roomId The unique identifier of the room.
     * @return A string representing the area of the room, or an error message if not found.
     */
    public String getAreaOfRoom(int buildingId, int floorId, int roomId) {
        Room room = mainTransformer.findRoomById(buildingId, floorId, roomId);
        if (room == null) {
            return "Pokój o id: " + roomId + " na piętrze o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Powierzchnia pokoju wynosi: " + room.getArea();
    }

    /**
     * Returns the cube of the room.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param roomId The unique identifier of the room.
     * @return A string representing the cube of the room, or an error message if not found.
     */
    public String getCubeOfRoom(int buildingId, int floorId, int roomId) {
        Room room = mainTransformer.findRoomById(buildingId, floorId, roomId);
        if (room == null) {
            return "Pokój o id: " + roomId + " na piętrze o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Kubatora pokoju wynosi: " + room.getCube();
    }

    /**
     * Returns the lighting level of the room.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param roomId The unique identifier of the room.
     * @return A string representing the average lighting of the room in lux per square meter, or an error message if not found.
     */
    public String getLightOfRoom(int buildingId, int floorId, int roomId) {
        Room room = mainTransformer.findRoomById(buildingId, floorId, roomId);
        if (room == null) {
            return "Pokój o id: " + roomId + " na piętrze o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Oświetlenie pokoju na m^2 wynosi: " + room.getAverageRoomLight();
    }

    /**
     * Returns the heating consumption of the room.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param roomId The unique identifier of the room.
     * @return A string representing the average heating consumption of the room per cubic meter, or an error message if not found.
     */
    public String getHeatingOfRoom(int buildingId, int floorId, int roomId) {
        Room room = mainTransformer.findRoomById(buildingId, floorId, roomId);
        if (room == null) {
            return "Pokój o id: " + roomId + " na piętrze o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Zużycie energii na m^3 wynosi w pomieszczeniu " + room.getAverageRoomHeating();
    }

    /**
     * Returns the cost of heating energy for the room over a given number of days.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param roomId The unique identifier of the room.
     * @param numberOfDays The number of days over which the heating cost is calculated.
     * @param price The price per unit of energy.
     * @return A string representing the total heating cost for the room over the specified number of days, or an error message if not found.
     */
    public String getHeatingCostOfRoom(int buildingId, int floorId, int roomId, int numberOfDays, float price) {
        Room room = mainTransformer.findRoomById(buildingId, floorId, roomId);
        if (room == null) {
            return "Pokój o id: " + roomId + " na piętrze o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Koszt energii w pokoju o id " + roomId + " w ciągu " + numberOfDays + " dni wynosi: " + room.getRoomHeatingCost(numberOfDays, price) + " zł";
    }
}
