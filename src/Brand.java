/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Brand represent a brand in the brands table in the database ShoeStore
 * <p>
 * a brand has
 * id: id of the brand in the table
 * brand: brand of the Brand
 */
public class Brand {

    private int id = 0; // id: id of the brand in the table
    private String brand = null; // brand: brand of the brand

    /**
     * Constructor that takes in all parameters of Brand
     *
     * @param id    id: id of the brand in the table
     * @param brand brand: brand of the brand
     */
    public Brand(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    /**
     * Default Constructor of Brand
     */
    public Brand() {
    }

    /**
     * Getter for the id
     *
     * @return id: id of the brand in the table
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id
     *
     * @param id id: id of the brand in the table
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the brand
     *
     * @return brand: brand of the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for the brand
     *
     * @param brand brand: brand of the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Returns a string that represents the value of Brand
     *
     * @return String representation of Brand
     */
    @Override
    public String toString() {
        return getBrand();
    }
}
