package pl.put.poznan.buildinginfo.logic;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Floor;

/**
 * This class is responsible for transforming floor data, 
 * including calculating various parameters such as area, cube, 
 * light levels, and heating costs for a specific floor in a building.
 */
@Component
public class FloorTransformer {

    private final MainTransformer mainTransformer;

    /**
     * Constructor that initializes the FloorTransformer with a MainTransformer.
     * 
     * @param mainTransformer The MainTransformer instance used to fetch floor data.
     */
    public FloorTransformer(MainTransformer mainTransformer) {
        this.mainTransformer = mainTransformer;
    }

    /**
     * Returns the area of the floor.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @return A string representing the area of the floor, or an error message if not found.
     */
    public String getAreaOfFloor(int buildingId, int floorId) {
        Floor floor = mainTransformer.findFloorById(buildingId, floorId);
        if (floor == null) {
            return "Piętro o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Powierzchnia piętra wynosi: " + floor.getFloorArea();
    }

    /**
     * Returns the cube of the floor.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @return A string representing the cube of the floor, or an error message if not found.
     */
    public String getCubeOfFloor(int buildingId, int floorId) {
        Floor floor = mainTransformer.findFloorById(buildingId, floorId);
        if (floor == null) {
            return "Piętro o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Kubatora piętra wynosi: " + floor.getFloorCube();
    }

    /**
     * Returns the lighting level of the floor.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @return A string representing the average lighting of the floor in lux per square meter, or an error message if not found.
     */
    public String getLightOfFloor(int buildingId, int floorId) {
        Floor floor = mainTransformer.findFloorById(buildingId, floorId);
        if (floor == null) {
            return "Piętro o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Oświetlenie piętra na m^2 wynosi: " + floor.getAverageFloorLight();
    }

    /**
     * Returns the heating consumption of the floor.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @return A string representing the average heating consumption of the floor per cubic meter, or an error message if not found.
     */
    public String getHeatingOfFloor(int buildingId, int floorId) {
        Floor floor = mainTransformer.findFloorById(buildingId, floorId);
        if (floor == null) {
            return "Piętro o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Zużycie energii na m^3 na piętrze wynosi " + floor.getAverageFloorHeating();
    }

    /**
     * Returns the cost of heating energy for the floor over a given number of days.
     * 
     * @param buildingId The unique identifier of the building.
     * @param floorId The unique identifier of the floor.
     * @param numberOfDays The number of days over which the heating cost is calculated.
     * @param price The price per unit of energy.
     * @return A string representing the total heating cost for the floor over the specified number of days, or an error message if not found.
     */
    public String getHeatingCostOfFloor(int buildingId, int floorId, int numberOfDays, float price) {
        Floor floor = mainTransformer.findFloorById(buildingId, floorId);
        if (floor == null) {
            return "Piętro o id: " + floorId + " w budynku o id: " + buildingId + " nie istnieje";
        }
        return "Koszt energii na piętrze o id " + floorId + " w ciągu " + numberOfDays + " dni wynosi: " + floor.getHeatingCostFloor(numberOfDays, price) + " zł";
    }
}
