/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

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
    private int shoe = 0; // shoe: shoe that was commented
    private int customer = 0; // customer: customer that placed the Comment on the shoe

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
    public int getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that was commented on
     *
     * @param shoe shoe: shoe that was commented
     */
    public void setShoe(int shoe) {
        this.shoe = shoe;
    }

    /**
     * Getter for the customer that placed the Comment
     *
     * @return customer: customer that placed the Comment on the shoe
     */
    public int getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer that placed the Comment
     *
     * @param customer customer: customer that placed the Comment on the shoe
     */
    public void setCustomer(int customer) {
        this.customer = customer;
    }
}
