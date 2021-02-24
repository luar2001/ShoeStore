/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

import java.util.Objects;

/**
 * Comment represent a comment in the Comments table in the database ShoeStore
 * <p>
 * A Comment has
 * id: id of the Comment
 * comment: comment of the Comment
 * shoe: shoe that was commented
 * customer: customer that placed the Comment on the shoe
 */
public class Comment {
    private int id = 0; // id: id of the Comment
    private String comment = null; // comment: comment of the Comment
    private Shoe shoe = null; // shoe: shoe that was commented
    private Customer customer = null; // customer: customer that placed the Comment on the shoe

    /**
     * Constructor for Comment that takes in all parameters
     *
     * @param id       id: id of the Comment
     * @param comment  comment: comment of the Comment
     * @param shoe     shoe: shoe that was commented
     * @param customer customer: customer that placed the Comment on the shoe
     */
    public Comment(int id, String comment, Shoe shoe, Customer customer) {
        this.id = id;
        this.comment = comment;
        this.shoe = shoe;
        this.customer = customer;
    }

    /**
     * Default Constructor for Comment
     */
    public Comment() {
    }

    /**
     * Getter for the id of the Comment
     *
     * @return id: id of the Comment
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Comment
     *
     * @param id id: id of the Comment
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the comment of the Comment
     *
     * @return comment: comment of the Comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for the comment of the Comment
     *
     * @param comment comment: comment of the Comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for the shoe that was commented on
     *
     * @return shoe: shoe that was commented
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that was commented on
     *
     * @param shoe shoe: shoe that was commented
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    /**
     * Getter for the customer that placed the Comment
     *
     * @return customer: customer that placed the Comment on the shoe
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer that placed the Comment
     *
     * @param customer customer: customer that placed the Comment on the shoe
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns a String representation of Comment
     *
     * @return String representation of Comment
     */
    @Override
    public String toString() {
        return "Comment: " + getComment() + " on Shoe: " + getShoe().toString() + " posted by: " + getCustomer().toString();
    }

    /**
     * checks if the comment is the exact same as another comment
     *
     * @param o object that will be checked if its equal
     * @return boolean (true if its equal | false if its not equals)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment1 = (Comment) o;
        return id == comment1.id && comment.equals(comment1.comment) && shoe.equals(comment1.shoe) && customer.equals(comment1.customer);
    }

    /**
     * Auto generated hashcode
     *
     * @return int hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, comment, shoe, customer);
    }
}
