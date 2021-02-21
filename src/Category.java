/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Category represent a category in the Categories table in the database ShoeStore
 * <p>
 * A Category has
 * id: id of the Category in the Categories table
 * category: category of the Category
 */
public class Category {
    private int id = 0; // id: id of the Category in the Categories table
    private String category = null; // category: category of the Category

    /**
     * Constructor for Category that takes in all parameters
     *
     * @param id       id: id of the Category in the Categories table
     * @param category category: category of the Category
     */
    public Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    /**
     * Default Constructor for Category
     */
    public Category() {
    }

    /**
     * Getter for the id of the Category
     *
     * @return id: id of the Category in the Categories table
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the Category
     *
     * @param id id: id of the Category in the Categories table
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the category of the Category
     *
     * @return category: category of the Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the category of the Category
     *
     * @param category category: category of the Category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns a string that represents the value of Brand
     *
     * @return String representation of Category
     */
    @Override
    public String toString() {
        return getCategory();
    }
}
