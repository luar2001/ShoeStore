/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

import java.util.Date;

/**
 * OutOfStock is a Object representation of the table of the same name in the ShoeStore database
 * <p>
 * OutOfStock has
 * id: id of the shoe that is out of stock
 * date: the date the shoe became out of stock
 * shoe: the shoe that is out of stock
 */
public class OutOfStock {
    private int id = 0; // id: id of the shoe that is out of stock
    private Date date = null; // date: the date the shoe became out of stock
    private Shoe shoe = null; // shoe: the shoe that is out of stock

    /**
     * Constructor for OutOfStock that takes in all parameters
     *
     * @param id   id: id of the shoe that is out of stock
     * @param date date: the date the shoe became out of stock
     * @param shoe shoe: the shoe that is out of stock
     */
    public OutOfStock(int id, Date date, Shoe shoe) {
        this.id = id;
        this.date = date;
        this.shoe = shoe;
    }

    /**
     * Default Constructor for OutOfStock
     */
    public OutOfStock() {
    }

    /**
     * Getter for the id of the row in the OutOfStock table
     *
     * @return id: id of the shoe that is out of stock
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the row in the OutOfStock table
     *
     * @param id id: id of the shoe that is out of stock
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the date the shoe went out of stock
     *
     * @return date: the date the shoe became out of stock
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date the shoe went out of stock
     *
     * @param date date: the date the shoe became out of stock
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for the shoe that went out of stock
     *
     * @return shoe: the shoe that is out of stock
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that went out of stock
     *
     * @param shoe shoe: the shoe that is out of stock
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    @Override
    public String toString() {
        return getShoe().toString() + " Went Out of stock " + getDate();
    }
}
