/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Rating represents a rating in the Ratings table of the ShoeStore database
 * <p>
 * Rating has
 * id: the id of the rating
 * rating: the rating of the Rating
 * nRating: a number value for the rating
 */
public class Rating {
    private int id = 0; // id: the id of the rating
    private String rating = null; // rating: the rating of the Rating
    private int nRating = 0; // nRating: a number value for the rating

    /**
     * Constructor for Rating that takes in all parameters
     *
     * @param id      id: the id of the rating
     * @param rating  rating: the rating of the Rating
     * @param nRating nRating: a number value for the rating
     */
    public Rating(int id, String rating, int nRating) {
        this.id = id;
        this.rating = rating;
        this.nRating = nRating;
    }

    /**
     * Default Constructor for Rating
     */
    public Rating() {
    }

    /**
     * Getter for the id of the rating
     *
     * @return id: the id of the rating
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the rating
     *
     * @param id id: the id of the rating
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the rating of the Rating
     *
     * @return rating: the rating of the Rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Setter for the rating of the Rating
     *
     * @param rating rating: the rating of the Rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Getter for the nRating of the Rating
     *
     * @return nRating: a number value for the rating
     */
    public int getnRating() {
        return nRating;
    }

    /**
     * Setter for the nRating of the Rating
     *
     * @param nRating nRating: a number value for the rating
     */
    public void setnRating(int nRating) {
        this.nRating = nRating;
    }

    /**
     * Returns a string that represents the value of Rating
     *
     * @return String representation of Rating
     */
    @Override
    public String toString() {
        return getRating();
    }
}
