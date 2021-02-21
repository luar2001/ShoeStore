/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * IsIn Represent the isin table in the ShoeStore Database
 * <p>
 * IsIn Has
 * id: id of the IsIn
 * order: order that the shoe is in
 * shoe: shoe that is in the order
 */
public class IsIn {
    private int id = 0; // id: id of the IsIn
    private Order order = null; // order: order that the shoe is in
    private Shoe shoe = null; // shoe: shoe that is in the order

    /**
     * Getter for the id of the IsIn
     *
     * @return id: id of the IsIn
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the IsIn
     *
     * @param id id: id of the IsIn
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the order the shoe is in
     *
     * @return order: order that the shoe is in
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Setter for the order the shoe is in
     *
     * @param order order: order that the shoe is in
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Getter for the shoe that is in the order
     *
     * @return shoe: shoe that is in the order
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Setter for the shoe that is in the order
     *
     * @param shoe shoe: shoe that is in the order
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
}
