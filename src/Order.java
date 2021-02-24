/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 */

import java.util.Date;

/**
 * Order represent the orders in the Orders table of the ShoeStore Database
 * <p>
 * Order has
 * id: id of the Order
 * date: the date the order was placed
 * customer: the customer that ordered the order
 */
public class Order {
    private int id = 0; // id: id of the Order
    private String name = null; //name so that i do not use id to select (assignment requirement)
    private Date date = null; // date: the date the order was placed
    private Customer customer = null; // customer: the customer that ordered the order

    /**
     * Constructor for Order that takes in all parameters
     *
     * @param id       id: id of the Order
     * @param date     date: the date the order was placed
     * @param customer customer: the customer that ordered the order
     */
    public Order(int id, Date date, Customer customer) {
        this.id = id;
        this.name = "order" + id;
        this.date = date;
        this.customer = customer;
    }

    /**
     * Default Constructor for Order
     */
    public Order() {
    }

    /**
     * Getter for the id of the Order
     *
     * @return id: id of the Order
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Order
     *
     * @param id id: id of the Order
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the name of the order
     *
     * @return name of the order....
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the order
     *
     * @param name name of the order....
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the date the Order was placed
     *
     * @return date: the date the order was placed
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date the Order was placed
     *
     * @param date date: the date the order was placed
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for the customer that placed the Order
     *
     * @return customer: the customer that ordered the order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer that placed the Order
     *
     * @param customer customer: the customer that ordered the order
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns a String representation of Order
     *
     * @return String representation of Order
     */
    @Override
    public String toString() {
        return name + " was placed on " + date + " by " + getCustomer().toString();
    }
}

