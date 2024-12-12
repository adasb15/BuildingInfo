package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;

@Component
public class BuildingTransformer {

    private final List<Building> buildings = new ArrayList<>();

     public BuildingTransformer(List<Building> build) {

        List<Building> buildings = build;
    }

    public BuildingTransformer() {
    }

    // Metoda do dodawania budynku
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    // Metoda do dodawania budynku z JSON
    public void addBuildingFromJson(Building building) {
        addBuilding(building);
    }

    // Zwracanie listy wszystkich budynków
    public List<Building> getAllBuildings() {
        return buildings;
    }

    // Metoda zwracająca powierzchnie budynku
    public String getAreaOfBuilding(int id1) {
        for (int i=0; i < buildings.size(); i++){
            System.out.println(buildings.get(i).getId());
            if(buildings.get(i).getId() == id1){
                return "Powierzchnia budynku o id: "+id1+" wynosi: "+String.valueOf(buildings.get(i).getBuildingArea());
            }
        }
        return "Budynek o id: "+String.valueOf(id1)+" nie istnieje";
    }

    // Metoda zwracająca powierzchnię piętra
    public String getAreaOfFloor(int id1, int id2) {
        for (int i=0; i < buildings.size(); i++){
            if(buildings.get(i).getId() == id1){
                for (int j=0; j < buildings.get(i).floors.size(); j++){
                    if(buildings.get(i).floors.get(j).getId() == id2){
                        return "Powierzchnia piętra wynosi: "+String.valueOf(buildings.get(i).floors.get(j).getFloorArea());
                    }
                }
            }
        }
        return "Pięto o id: "+String.valueOf(id2)+" w budynku o id "+String.valueOf(id1)+ " nie istnieje";
    }

    //Metoda zwracająca powierzchnię pokoju
    public String getAreaOfRoom(int id1, int id2, int id3) {
        for (int i=0; i < buildings.size(); i++){
            if(buildings.get(i).getId() == id1){
                for (int j=0; j < buildings.get(i).floors.size(); j++){
                    if(buildings.get(i).floors.get(j).getId() == id2){
                        for (int k=0; k < buildings.get(i).floors.get(j).rooms.size(); k++){
                            if(buildings.get(i).floors.get(j).rooms.get(k).getId() == id3){
                                return "Powierzchnia okoju wynosi: "
                                        +String.valueOf(buildings.get(i).floors.get(j).rooms.get(k).getArea());
                            }
                        }
                    }
                }
            }
        }
        return "Pokój o id: "+String.valueOf(id3)+" na piętrze o id: "+String.valueOf(id2)+" w budynku o id: "
                +String.valueOf(id1)+" nie istnieje";
    }

    //Metody zwracające kubature budynku, pietra i pomieszczenia
    public String getCubeOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Kubatura budynku wynosi: " + String.valueOf(buildings.get(i).getBuildingCube());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }

    public String getCubeOfFloor(int id1, int id2) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        return "Kubatura piętra wynosi: " + String.valueOf(buildings.get(i).floors.get(j).getFloorCube());
                    }
                }
            }
        }
        return "Piętro o id: " + String.valueOf(id2) + " w budynku o id " + String.valueOf(id1) + " nie istnieje";
    }

    public String getCubeOfRoom(int id1, int id2, int id3) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        for (int k = 0; k < buildings.get(i).floors.get(j).rooms.size(); k++) {
                            if (buildings.get(i).floors.get(j).rooms.get(k).getId() == id3) {
                                return "Kubatura pokoju wynosi: "
                                        + String.valueOf(buildings.get(i).floors.get(j).rooms.get(k).getCube());
                            }
                        }
                    }
                }
            }
        }
        return "Pokój o id: " + String.valueOf(id3) + " na piętrze o id: " + String.valueOf(id2) + " w budynku o id: "
                + String.valueOf(id1) + " nie istnieje";

    }

    // Metody zwracające oświetlenie budynku, pietra i pomieszczenia
     public String getLightOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Oświetlenie budynku na m^2 wynosi: "
                        + String.valueOf(buildings.get(i).getAverageBuildingLight());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }

    public String getLightOfFloor(int id1, int id2) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        return "Oświetlenie piętra na m^2 wynosi: "
                                + String.valueOf(buildings.get(i).floors.get(j).getAverageFloorLight());
                    }
                }
            }
        }
        return "Piętro o id: " + String.valueOf(id2) + " w budynku o id " + String.valueOf(id1) + " nie istnieje";
    }

    public String getLightOfRoom(int id1, int id2, int id3) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        for (int k = 0; k < buildings.get(i).floors.get(j).rooms.size(); k++) {
                            if (buildings.get(i).floors.get(j).rooms.get(k).getId() == id3) {
                                return "Oświetlenie pokoju na m^2 wynosi: "
                                        + String.valueOf(buildings.get(i).floors.get(j).rooms.get(k).getAverageRoomLight());
                            }
                        }
                    }
                }
            }
        }
        return "Pokój o id: " + String.valueOf(id3) + " na piętrze o id: " + String.valueOf(id2) + " w budynku o id: "
                + String.valueOf(id1) + " nie istnieje";
    }
    // Metody zwracajace ogrzewanie budynku, pietra i pomieszczenia
    public String getHeatingOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Zużycie energii na m^3 w budynku wynosi " + String.valueOf(buildings.get(i).getAverageBuildingHeating());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }

    public String getHeatingOfFloor(int id1, int id2) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        return "Zużycie energii na m^3 na piętrze wynosi " + String.valueOf(buildings.get(i).floors.get(j).getAverageFloorHeating());
                    }
                }
            }
        }
        return "Piętro o id: " + String.valueOf(id2) + " w budynku o id " + String.valueOf(id1) + " nie istnieje";
    }

    public String getHeatingOfRoom(int id1, int id2, int id3) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                for (int j = 0; j < buildings.get(i).floors.size(); j++) {
                    if (buildings.get(i).floors.get(j).getId() == id2) {
                        for (int k = 0; k < buildings.get(i).floors.get(j).rooms.size(); k++) {
                            if (buildings.get(i).floors.get(j).rooms.get(k).getId() == id3) {
                                return "Zużycie energii na m^3 wynosi w pomieszczeniu " + String.valueOf(buildings.get(i).floors.get(j).rooms.get(k).getAverageRoomHeating());
                            }
                        }
                    }
                }
            }
        }
        return "Pokój o id: " + String.valueOf(id3) + " na piętrze o id: " + String.valueOf(id2) + " w budynku o id: "
                + String.valueOf(id1) + " nie istnieje";
    }
}
