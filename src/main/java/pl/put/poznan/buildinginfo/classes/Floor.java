package pl.put.poznan.buildinginfo.classes;

import java.util.ArrayList;
import java.util.List;

public class Floor extends Location {

    public List<Room> rooms;

    /**
     * Constructor of a Floor
     *
     * @param id param id is the id of the floor
     * @param name param name is the name of the floor
     */

    public Floor(int id, String name) {
        super(id, name);
        this.rooms = new ArrayList<>();
    }
}
