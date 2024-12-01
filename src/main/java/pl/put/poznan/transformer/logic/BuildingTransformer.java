package pl.put.poznan.buildinginfo.logic;
//importing class files - starting with class Building
import pl.put.poznan.buildinginfo.classes.Building;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BuildingTransformer {

    public List<Building> buildings = new ArrayList<>();

    public BuildingTransformer(List<Building> build) {

        List<Building> buildings = build;

    }

        public List<Building> getAllBuildings() {
        return buildings;
    }

    public void addBuildings(List<Building> newBuildings) {
        for (int i=0; i < newBuildings.size(); i++){
            buildings.add(newBuildings.get(i));
        }
    }

}
