package pl.put.poznan.buildinginfo.logic;
//importing class files - starting with class Building
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */


@Component
public class BuildingTransformer {

    public List<Building> buildings = new ArrayList<>();

    public BuildingTransformer(List<Building> build) {

        this.buildings = build;

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
