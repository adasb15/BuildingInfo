package pl.put.poznan.buildinginfo.logic;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;

/**
 * This class is responsible for transforming building data, 
 * including calculating various parameters such as area, cube, 
 * light levels, and heating costs for a specific building.
 */
@Component
public class BuildingTransformer {

    private final MainTransformer mainTransformer;

    /**
     * Constructor that initializes the BuildingTransformer with a MainTransformer.
     * 
     * @param mainTransformer The MainTransformer instance used to fetch building data.
     */
    public BuildingTransformer(MainTransformer mainTransformer) {
        this.mainTransformer = mainTransformer;
    }

    /**
     * Returns the area of the building.
     * 
     * @param buildingId The unique identifier of the building.
     * @return A string representing the area of the building, or an error message if not found.
     */
    public String getAreaOfBuilding(int buildingId) {
        Building building = mainTransformer.findBuildingById(buildingId);
        if (building == null) {
            return "Budynek o id: " + buildingId + " nie istnieje";
        }
        return "Powierzchnia budynku wynosi: " + building.getBuildingArea();
    }

    /**
     * Returns the cube of the building.
     * 
     * @param buildingId The unique identifier of the building.
     * @return A string representing the cube of the building, or an error message if not found.
     */
    public String getCubeOfBuilding(int buildingId) {
        Building building = mainTransformer.findBuildingById(buildingId);
        if (building == null) {
            return "Budynek o id: " + buildingId + " nie istnieje";
        }
        return "Kubatura budynku wynosi: " + building.getBuildingCube();
    }

    /**
     * Returns the lighting level of the building.
     * 
     * @param buildingId The unique identifier of the building.
     * @return A string representing the average lighting of the building in lux per square meter, or an error message if not found.
     */
    public String getLightOfBuilding(int buildingId) {
        Building building = mainTransformer.findBuildingById(buildingId);
        if (building == null) {
            return "Budynek o id: " + buildingId + " nie istnieje";
        }
        return "Oświetlenie pokoju na m^2 wynosi: " + building.getAverageBuildingLight();
    }

    /**
     * Returns the heating consumption of the building.
     * 
     * @param buildingId The unique identifier of the building.
     * @return A string representing the average heating consumption of the building per cubic meter, or an error message if not found.
     */
    public String getHeatingOfBuilding(int buildingId) {
        Building building = mainTransformer.findBuildingById(buildingId);
        if (building == null) {
            return "Budynek o id: " + buildingId + " nie istnieje";
        }
        return "Zużycie energii na m^3 wynosi w pomieszczeniu  " + building.getAverageBuildingHeating();
    }

    /**
     * Returns the cost of heating energy for the building over a given number of days.
     * 
     * @param buildingId The unique identifier of the building.
     * @param numberOfDays The number of days over which the heating cost is calculated.
     * @param price The price per unit of energy.
     * @return A string representing the total heating cost for the building over the specified number of days, or an error message if not found.
     */
    public String getHeatingCostOfBuilding(int buildingId, int numberOfDays, float price) {
        Building building = mainTransformer.findBuildingById(buildingId);
        if (building == null) {
            return "Budynek o id: " + buildingId + " nie istnieje";
        }
        return "Koszt energii w budynku o id " + buildingId + " w ciągu " + numberOfDays + " dni wynosi: " + building.getHeatingCostBuilding(numberOfDays, price) + " zł";
    }
}
