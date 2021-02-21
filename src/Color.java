/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Color represents a color in the Colors table in the ShoeStore Database
 * <p>
 * a Color has
 * id: of the color
 * color: color of the color
 */
public class Color {

    private int id = 0; // id: of the color
    private String color = null; // color: color of the color

    /**
     * Getter for the id of the color
     *
     * @return id: of the color
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the color
     *
     * @param id id: of the color
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for the color of the color
     *
     * @return color: color of the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color of the color
     *
     * @param color color: color of the color
     */
    public void setColor(String color) {
        this.color = color;
    }
}
