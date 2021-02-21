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
 * id: id of the Shoe in the database
 * price: the amount the Shoe costs
 * amount: the amount of the Shoe that is in stock
 * size: the size of the Shoe
 * brand: the brand that made the Shoe
 * color: the color of the Shoe
 */
public class Shoe {

    // represents all the values in the Shoes table
    private int id = 0; // id: id of the Shoe in the database
    private int price = 0; // price: the amount the Shoe costs
    private int amount = 0; // amount: the amount of the Shoe that is in stock
    private int size = 0; // size: the size of the Shoe
    private Brand brand = null; // brand: the brand that made the Shoe
    private Color color = null; // color: the color of the Shoe

    /**
     * Constructor that sets all the values
     *
     * @param id     id: id of the Shoe in the database
     * @param price  price: the amount the Shoe costs
     * @param amount amount: the amount of the Shoe that is in stock
     * @param size   size: the size of the Shoe
     * @param brand  brand: the brand that made the Shoe
     * @param color  color: the color of the Shoe
     */
    public Shoe(int id, int price, int amount, int size, Brand brand, Color color) {
        setId(id);
        setPrice(price);
        setAmount(amount);
        setSize(size);
        setBrand(brand);
        setColor(color);
    }

    /**
     * Default Constructor
     */
    public Shoe() {
    }


    /**
     * Getter for the Shoe's id
     *
     * @return id: id of the Shoe in the database
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the Shoe's id
     *
     * @param id id: id of the Shoe in the database
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the Shoe's price
     *
     * @return price: the amount the Shoe costs
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for this Shoe's price
     *
     * @param price price: the amount the Shoe costs
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for this Shoe's amount
     *
     * @return amount: the amount of the Shoe that is in stock
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter for this Shoe's amount
     *
     * @param amount amount: the amount of the Shoe that is in stock
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Getter for this Shoe's size
     *
     * @return size: the size of the Shoe
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter for this Shoe's size
     *
     * @param size size: the size of the Shoe
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Getter for the Shoe's brand
     *
     * @return brand: the brand that made the Shoe
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Setter for the Shoe's price
     *
     * @param brand brand: the brand that made the Shoe
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Getter for the Shoe's color
     *
     * @return color: the color of the Shoe
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for the Shoe's color
     *
     * @param color color: the color of the Shoe
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Returns all all values that the user will wanna see from shoe, it excludes amount and id
     * Returns a string with the important parts of a shoe in the order of
     * Brand , Color , Size then prize
     *
     * @return String representation of the values within Shoe
     */
    @Override
    public String toString() {
        return (getBrand().getBrand() + " " + getColor().getColor() + " " + getSize() + " " + getPrice());
    }
}
