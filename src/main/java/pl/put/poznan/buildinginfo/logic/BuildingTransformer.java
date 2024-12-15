package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.put.poznan.buildinginfo.classes.Building;

/**
 * The {@code BuildingTransformer} class is a Spring-managed component that provides methods
 * for managing buildings and retrieving information such as area, volume (cube), lighting, and heating
 * for buildings, floors, and rooms.
 */
@Component
public class BuildingTransformer {

    /**
     * The list of buildings managed by this transformer.
     */
    private final List<Building> buildings = new ArrayList<>();

    /**
     * Constructs a {@code BuildingTransformer} with a predefined list of buildings.
     *
     * @param build the initial list of buildings
     */
    public BuildingTransformer(List<Building> build) {
        List<Building> buildings = build;
    }

    /**
     * Constructs an empty {@code BuildingTransformer}.
     */
    public BuildingTransformer() {
    }

    /**
     * Adds a building to the managed list.
     *
     * @param building the building to add
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * Adds a building to the managed list using a JSON representation.
     *
     * @param building the building to add
     */
    public void addBuildingFromJson(Building building) {
        addBuilding(building);
    }

    /**
     * Returns the list of all managed buildings.
     *
     * @return the list of buildings
     */
    public List<Building> getAllBuildings() {
        return buildings;
    }

    /**
     * Returns the area of a building by its ID.
     *
     * @param id1 the ID of the building
     * @return the area of the building as a string, or a message indicating that the building does not exist
     */
    public String getAreaOfBuilding(int id1) {
        for (int i=0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).getId());
            if(buildings.get(i).getId() == id1) {
                return "Powierzchnia budynku o id: "+id1+" wynosi: "+String.valueOf(buildings.get(i).getBuildingArea());
            }
        }
        return "Budynek o id: "+String.valueOf(id1)+" nie istnieje";
    }

    /**
     * Returns the area of a floor in a building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @return the area of the floor as a string, or a message indicating that the floor does not exist
     */
    public String getAreaOfFloor(int id1, int id2) {
        for (int i=0; i < buildings.size(); i++) {
            if(buildings.get(i).getId() == id1) {
                for (int j=0; j < buildings.get(i).floors.size(); j++) {
                    if(buildings.get(i).floors.get(j).getId() == id2) {
                        return "Powierzchnia piętra wynosi: "+String.valueOf(buildings.get(i).floors.get(j).getFloorArea());
                    }
                }
            }
        }
        return "Piętro o id: "+String.valueOf(id2)+" w budynku o id "+String.valueOf(id1)+" nie istnieje";
    }

    /**
     * Returns the area of a room in a floor and building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @param id3 the ID of the room
     * @return the area of the room as a string, or a message indicating that the room does not exist
     */
    public String getAreaOfRoom(int id1, int id2, int id3) {
        for (int i=0; i < buildings.size(); i++) {
            if(buildings.get(i).getId() == id1) {
                for (int j=0; j < buildings.get(i).floors.size(); j++) {
                    if(buildings.get(i).floors.get(j).getId() == id2) {
                        for (int k=0; k < buildings.get(i).floors.get(j).rooms.size(); k++) {
                            if(buildings.get(i).floors.get(j).rooms.get(k).getId() == id3) {
                                return "Powierzchnia pokoju wynosi: "
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

    /**
     * Returns the volume (cube) of a building by its ID.
     *
     * @param id1 the ID of the building
     * @return the volume of the building as a string, or a message indicating that the building does not exist
     */
    public String getCubeOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Kubatura budynku wynosi: " + String.valueOf(buildings.get(i).getBuildingCube());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }
    /**
     * Returns the volume (cube) of a floor within a building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @return the volume of the floor as a string, or a message indicating that the floor does not exist
     */
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

    /**
     * Returns the volume (cube) of a room within a floor and building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @param id3 the ID of the room
     * @return the volume of the room as a string, or a message indicating that the room does not exist
     */
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

    /**
     * Returns the lighting efficiency of a building by its ID.
     *
     * @param id1 the ID of the building
     * @return the lighting efficiency as a string, or a message indicating that the building does not exist
     */
    public String getLightOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Oświetlenie budynku na m^2 wynosi: "
                        + String.valueOf(buildings.get(i).getAverageBuildingLight());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }

    /**
     * Returns the lighting efficiency of a floor within a building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @return the lighting efficiency of the floor as a string, or a message indicating that the floor does not exist
     */
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

    /**
     * Returns the lighting efficiency of a room within a floor and building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @param id3 the ID of the room
     * @return the lighting efficiency of the room as a string, or a message indicating that the room does not exist
     */
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

    /**
     * Returns the heating efficiency of a floor within a building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @return the heating efficiency of the floor as a string, or a message indicating that the floor does not exist
     */
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

    /**
     * Returns the heating efficiency of a building by its ID.
     *
     * @param id1 the ID of the building
     * @return the heating efficiency as a string, or a message indicating that the building does not exist
     */
    public String getHeatingOfBuilding(int id1) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id1) {
                return "Zużycie energii na m^3 w budynku wynosi " + String.valueOf(buildings.get(i).getAverageBuildingHeating());
            }
        }
        return "Budynek o id: " + String.valueOf(id1) + " nie istnieje";
    }

    /**
     * Returns the heating efficiency of a room within a floor and building by their IDs.
     *
     * @param id1 the ID of the building
     * @param id2 the ID of the floor
     * @param id3 the ID of the room
     * @return the heating efficiency of the room as a string, or a message indicating that the room does not exist
     */
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
