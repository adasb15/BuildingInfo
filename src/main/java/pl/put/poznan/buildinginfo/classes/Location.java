package pl.put.poznan.buildinginfo.classes;

/**
 * The {@code Location} class serves as an abstract base class for locations such as buildings, floors, and rooms.
 * <p>
 * It provides common attributes and methods for managing the identification and naming of locations,
 * as well as placeholders for calculating specific parameters like area, heating, lighting, and volume (cube).
 * </p>
 */
public abstract class Location {

    /**
     * The unique identifier of the location.
     */
    public int id;

    /**
     * The name of the location.
     */
    public String name;

    /**
     * Constructs a {@code Location} with the specified ID and name.
     *
     * @param id the unique identifier of the location
     * @param name the name of the location
     */
    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the unique identifier of the location.
     *
     * @return the ID of the location
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the location.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the location.
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the area of the location.
     * <p>
     * This method should be overridden in subclasses.
     * </p>
     *
     * @return the area of the location (default: 0)
     */
    public float getArea() {
        return 0;
    }

    /**
     * Returns the heating power of the location.
     * <p>
     * This method should be overridden in subclasses.
     * </p>
     *
     * @return the heating power of the location (default: 0)
     */
    public float getHeating() {
        return 0;
    }

    /**
     * Returns the lighting power of the location.
     * <p>
     * This method should be overridden in subclasses.
     * </p>
     *
     * @return the lighting power of the location (default: 0)
     */
    public float getLight() {
        return 0;
    }

    /**
     * Returns the volume (cube) of the location.
     * <p>
     * This method should be overridden in subclasses.
     * </p>
     *
     * @return the volume of the location (default: 0)
     */
    public float getCube() {
        return 0;
    }
}
