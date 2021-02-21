/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Ratings represent the Rating table in the ShoeStore Database
 * <p>
 * Ratings has
 * id: id of the Ratings
 * shoe: shoe that has a rating
 * rating: rating that the shoe has
 * customer: the customer that placed the rating on the shoe
 */
public class Ratings {
    private int id = 0; // id: id of the Ratings
    private Shoe shoe = null; // shoe: shoe that has a rating
    private Rating rating = null; // rating: rating that the shoe has
    private Customer customer = null; // customer: the customer that placed the rating on the shoe

    /**
     * Getter for the id of the Ratings
     *
     * @return id: id of the Ratings
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Ratings
     *
     * @param id id: id of the Ratings
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the shoe that has a rating
     *
     * @return shoe: shoe that has a rating
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that has a rating
     *
     * @param shoe shoe: shoe that has a rating
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    /**
     * Getter for the rating that the shoe has
     *
     * @return rating: rating that the shoe has
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Setter for the rating that the shoe has
     *
     * @param rating rating: rating that the shoe has
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * Getter for the customer that placed the rating on the shoe
     *
     * @return customer: the customer that placed the rating on the shoe
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer that placed the rating on the shoe
     *
     * @param customer customer: the customer that placed the rating on the shoe
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
