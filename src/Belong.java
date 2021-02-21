/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:34
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Belong represent the BelongsIn table in the ShoeStore Database
 * <p>
 * Belong has
 * id: id of the belong
 * shoe: the shoe that belongs to a Category
 * category: the category the shoe belongs in
 */
public class Belong {
    private int id = 0; // id: id of the belong
    private Shoe shoe = null; // shoe: the shoe that belongs to a Category
    private Category category = null; // category: the category the shoe belongs in

    /**
     * Getter for the id of the belong
     *
     * @return id: id of the belong
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the belong
     *
     * @param id id: id of the belong
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the shoe that belongs in a Category
     *
     * @return shoe: the shoe that belongs to a Category
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that belongs in a Category
     *
     * @param shoe shoe: the shoe that belongs to a Category
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    /**
     * Getter for the category the shoe belongs in
     *
     * @return category: the category the shoe belongs in
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setter for the category the shoe belongs in
     *
     * @param category category: the category the shoe belongs in
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
