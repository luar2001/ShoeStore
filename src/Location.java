/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Location represent a location in the Locations table in the database ShoeStore
 * <p>
 * A Location has
 * id: id of the Location
 * location: location of the Location
 */
public class Location {
    private int id = 0; // id: id of the Location
    private String location = null; // location: location of the Location

    /**
     * Getter for the id of the Location
     *
     * @return id: id of the Location
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Location
     *
     * @param id id: id of the Location
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the location of the Location
     *
     * @return location: location of the Location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the location of the Location
     *
     * @param location location: location of the Location
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
