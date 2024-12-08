package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;

@Component
public class BuildingTransformer {

    private final List<Building> buildings = new ArrayList<>();

    // Metoda do dodawania budynku
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    // Metoda do dodawania budynku z JSON (Jeśli potrzebujesz)
    public void addBuildingFromJson(Building building) {
        addBuilding(building);
    }

    // Zwracanie listy wszystkich budynków
    public List<Building> getAllBuildings() {
        return buildings;
    }
}
