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
 * color: color of the Color
 */
public class Color {
    private int id = 0; // id: of the color
    private String color = null; // color: color of the color

    /**
     * Constructor that takes in all values and sets them.
     *
     * @param id    id: of the color
     * @param color color: color of the color
     */
    public Color(int id, String color) {
        setId(id);
        setColor(color);
    }

    /**
     * Default constructor for color
     */
    public Color() {
    }

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
     * Setter for the color of the Color
     *
     * @return color: color of the Color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color of the Color
     *
     * @param color color: color of the Color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a string that represents the value of color one would want in string form in this case the color
     *
     * @return String representation of Color
     */
    @Override
    public String toString() {
        return getColor();
    }
}
