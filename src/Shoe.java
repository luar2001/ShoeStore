/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:33
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Shoe represent a shoe in the Shoes table in the database ShoeStore
 * <p>
 * a Shoe has
 * id: id of the shoe in the database
 * price: the amount the shoe costs
 * amount: the amount of the shoe that is in stock
 * size: the size of the shoe
 * brand: the brand that made the shoe (int that represents a brand form the Brands table)
 * color: the color of the shoe (int that represents a color form the Colors table)
 */
public class Shoe {

    // represents all the values in the Shoes table
    private int id = 0; // id: id of the shoe in the database
    private int price = 0; // price: the amount the shoe costs
    private int amount = 0; // amount: the amount of the shoe that is in stock
    private int size = 0; // size: the size of the shoe
    private int brand = 0; // brand: the brand that made the shoe (int that represents a brand form the Brands table)
    private int color = 0; // color: the color of the shoe (int that represents a color form the Colors table)

    /**
     * Getter for the shoe's id
     *
     * @return id: id of the shoe in the database
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the shoe's id
     *
     * @param id id: id of the shoe in the database
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the shoe's price
     *
     * @return price: the amount the shoe costs
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for this shoe's price
     *
     * @param price price: the amount the shoe costs
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for this shoe's amount
     *
     * @return amount: the amount of the shoe that is in stock
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter for this shoe's amount
     *
     * @param amount amount: the amount of the shoe that is in stock
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Getter for this shoe's size
     *
     * @return size: the size of the shoe
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter for this shoe's size
     *
     * @param size size: the size of the shoe
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Getter for the shoe's brand
     *
     * @return brand: the brand that made the shoe (int that represents a brand form the Brands table)
     */
    public int getBrand() {
        return brand;
    }

    /**
     * Setter for the shoe's price
     *
     * @param brand brand: the brand that made the shoe (int that represents a brand form the Brands table)
     */
    public void setBrand(int brand) {
        this.brand = brand;
    }

    /**
     * Getter for the shoe's color
     *
     * @return color: the color of the shoe (int that represents a color form the Colors table)
     */
    public int getColor() {
        return color;
    }

    /**
     * Setter for the shoe's color
     *
     * @param color color: the color of the shoe (int that represents a color form the Colors table)
     */
    public void setColor(int color) {
        this.color = color;
    }
}
