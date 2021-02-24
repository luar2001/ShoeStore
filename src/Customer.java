/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 */

import java.util.Objects;

/**
 * Customer is a representation of the Customers table in the ShoeStore database
 * <p>
 * a Customer has
 * id: id of the Customer
 * firstName: the Customer's first name
 * lastName: the Customer's last name
 * username: the Customer's username
 * password: the Customer's password
 * location: the Customer's order location
 */
public class Customer {
    private int id = 0; // id: id of the Customer
    private String firstName = null; // firstName: the Customer's first name
    private String lastName = null; // lastName: the Customer's last name
    private String username = null; // username: the Customer's username
    private String password = null; // password: the Customer's password
    private Location location = null; // location: the Customer's order location

    /**
     * Constructor for Customer that takes in all parameters
     *
     * @param id        id: id of the Customer
     * @param firstName firstName: the Customer's first name
     * @param lastName  lastName: the Customer's last name
     * @param username  username: the Customer's username
     * @param password  password: the Customer's password
     * @param location  location: the Customer's order location
     */
    public Customer(int id, String firstName, String lastName, String username, String password, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.location = location;
    }

    /**
     * Default Constructor for Customer
     */
    public Customer() {
    }

    /**
     * Getter for the id of the Customer
     *
     * @return id: id of the Customer
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Customer
     *
     * @param id id: id of the Customer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the first name of the Customer
     *
     * @return firstName: the Customer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first name of the Customer
     *
     * @param firstName firstName: the Customer's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the last name of the Customer
     *
     * @return lastName: the Customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name of the Customer
     *
     * @param lastName lastName: the Customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the Customer's username
     *
     * @return username: the Customer's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for the Customer's username
     *
     * @param username username: the Customer's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for the Customer's password
     *
     * @return password: the Customer's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the Customer's password
     *
     * @param password password: the Customer's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the order location of the Customer
     *
     * @return location: the Customer's order location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setter for the order location of the Customer
     *
     * @param location location: the Customer's order location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Returns a String representation of Customer
     *
     * @return String representation of Customer
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Check for equality between this Customer and another Customer
     *
     * @param o object that will be checked for equality
     * @return boolean (true if it is equal | false if its not equal)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && username.equals(customer.username) && password.equals(customer.password) && location.equals(customer.location);
    }

    /**
     * auto generated hashcode override by intelli J
     *
     * @return int that represents the hashcode of this Customer
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, location);
    }
}
