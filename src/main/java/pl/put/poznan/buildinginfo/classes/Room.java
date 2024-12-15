package pl.put.poznan.buildinginfo.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@code Room} class represents a room within a building.
 * It extends the {@link Location} class and includes attributes for area, heating, lighting, and volume (cube).
 * The class provides methods to calculate average lighting and heating efficiency.
 */
public class Room extends Location {

    /**
     * The area of the room in square meters.
     */
    @JsonProperty("area")
    private float area;

    /**
     * The heating power of the room in kilowatts (kW).
     */
    @JsonProperty("heating")
    private float heating;

    /**
     * The lighting power of the room in lumens.
     */
    @JsonProperty("light")
    private float light;

    /**
     * The volume (cube) of the room in cubic meters.
     */
    @JsonProperty("cube")
    private float cube;

    /**
     * Constructs a {@code Room} with specific parameters.
     *
     * @param id      the unique identifier of the room
     * @param name    the name of the room
     * @param area    the area of the room in square meters
     * @param heating the heating power of the room in kilowatts (kW)
     * @param light   the lighting power of the room in lumens
     * @param cube    the volume (cube) of the room in cubic meters
     */
    public Room(int id, String name, float area, float heating, float light, float cube) {
        super(id, name);
        this.area = area;
        this.heating = heating;
        this.light = light;
        this.cube = cube;
    }

    /**
     * Constructs a {@code Room} with default values.
     * <p>
     * This no-argument constructor is required for deserialization.
     * </p>
     */
    public Room() {
        super(0, ""); // Calls the no-argument constructor of the parent class
    }

    /**
     * Returns the area of the room.
     *
     * @return the area of the room in square meters
     */
    @Override
    public float getArea() {
        return area;
    }

    /**
     * Returns the heating power of the room.
     *
     * @return the heating power of the room in kilowatts (kW)
     */
    @Override
    public float getHeating() {
        return heating;
    }

    /**
     * Returns the lighting power of the room.
     *
     * @return the lighting power of the room in lumens
     */
    @Override
    public float getLight() {
        return light;
    }

    /**
     * Returns the volume (cube) of the room.
     *
     * @return the volume of the room in cubic meters
     */
    @Override
    public float getCube() {
        return cube;
    }

    /**
     * Calculates the average lighting power per square meter for the room.
     *
     * @return the average lighting power per square meter
     * @throws IllegalArgumentException if the area of the room is zero
     */
    public float getAverageRoomLight() {
        if (area == 0) {
            throw new IllegalArgumentException("Area cannot be zero for average light calculation.");
        }
        return light / area;
    }

    /**
     * Calculates the average heating power per cubic meter for the room.
     *
     * @return the average heating power per cubic meter
     * @throws IllegalArgumentException if the volume (cube) of the room is zero
     */
    public float getAverageRoomHeating() {
        if (cube == 0) {
            throw new IllegalArgumentException("Cube cannot be zero for average heating calculation.");
        }
        return heating / cube;
    }
}
