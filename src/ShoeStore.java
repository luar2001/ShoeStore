import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.sql.Types.INTEGER;
import static java.sql.Types.NULL;

/*
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 *
 */
public class ShoeStore {

    /**
     * Main methods that start the program
     *
     * @param args argument of some kind.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner
        Data data = new Data(); // takes in the data from the database and make the tables into objects and then put them in lists

        //login
        Customer user = login(data.customers, scanner);
        System.out.println("Welcome " + user);

        //prints list of all the shoes
        System.out.println("\nBrand Color Size Price Average Rating");
        //user input
        Shoe shoe = selectShoe(data.shoes, scanner, data);

        //add to order / order shoe
        addToCart(user, shoe, scanner, data);
        System.out.println("\nWanna see whats in your order?");
        boolean yesOrNO = yesOrNO(scanner);
        if (yesOrNO) {
            data.update();
            listOrder(data.isIns, data.isIns.get(data.isIns.size() - 1).getOrder());
        }

        //rate and comment
        System.out.print("\nWanna rate and comment on the shoe?");
        boolean yesOrNO1 = yesOrNO(scanner);
        if (yesOrNO1) {
            rateAndComment(user, shoe, scanner, data);
        }

        System.out.print("\nWanna see the shoes comments?");
        boolean yesOrNO2 = yesOrNO(scanner);
        if (yesOrNO2) {
            data.update();
            listComments(shoe, data.comments);
        }

        System.out.println("\nBye :) ");
    }

    /**
     * /**
     * Checks if the user exists and "login"
     *
     * @param customers List of customers the user can be
     * @param scanner   scanner for taking in user input
     * @return the logged in user
     */
    private static Customer login(List<Customer> customers, Scanner scanner) {
        System.out.print("Please login \nInput Username: ");
        while (true) {
            try {
                String username = scanner.next();
                List<Customer> user = customers.stream().filter(customer -> customer.getUsername().equals(username)).collect(Collectors.toList());
                if (!user.isEmpty()) {//user with that username exists
                    System.out.print("Please Input Password: ");
                    String password = scanner.next();
                    if (user.get(0).getPassword().equals(password)) { //if password is correct
                        return user.get(0);
                    } else { //if password is wrong
                        System.out.print("Password was incorrect\nPlease input Username again: ");
                    }
                } else { //username dose not exist
                    System.out.print("\nUser with inputted Username dose not exist \nPlease Input Username again: ");
                }
            } catch (Exception e) {
                System.out.print("Please Try Again \nPlease Input Username: ");
            }
        }
    }

    /**
     * User selects a shoe form the list
     *
     * @param shoes   list of all the shoes
     * @param scanner scanner for taking in user input
     * @return the Shoe that was selected
     */
    private static Shoe selectShoe(List<Shoe> shoes, Scanner scanner, Data data) {
        System.out.println("\nChores a Shoe by typing a name");

        List<Shoe> availableShoes = shoes.stream()
                .filter(shoe -> shoe.getAmount() > 0).collect(Collectors.toList());
        availableShoes.forEach(shoe -> System.out.println(shoe.getName() + " | " + shoe.toString() + " " + averageRating(shoe) + " " + averageRatingText(averageRating(shoe), data.ratings)));

        while (true) {
            try {
                String input = scanner.next();
                List<Shoe> theShoe = availableShoes.stream().filter(shoe -> shoe.getName().equalsIgnoreCase(input)).collect(Collectors.toList());
                if (theShoe.iterator().hasNext()) {
                    System.out.println("\n" + theShoe.get(0).toString()); //prints out witch shoe the user selected
                    return theShoe.get(0);
                } else {
                    System.out.println("\nPlease input the name of one of the shoe from the list ");
                }
            } catch (Exception e) {
                System.out.println("\nYou need to input the name of one of the shoe from the list ");
            }
        }
    }

    /***
     * Lets the user pick between new or edit
     * @param scanner scanner for taking in user input
     */
    private static boolean editOrNew(Scanner scanner) {
        System.out.println("\nNew or Edit order (type new or edit) ");
        while (true) {
            try {
                String input = scanner.next().toLowerCase();
                if (input.equals("new")) {
                    return true;
                } else if (input.equals("edit")) {
                    return false;
                } else {
                    System.out.println("\nNew or Edit order (type new or edit) ");
                }
            } catch (Exception e) {
                System.out.println("\nNew or Edit order (type new or edit) ");
            }
        }
    }

    /**
     * adds or edits an order in the database
     *
     * @param customer customer that places the new order
     * @param shoe     Shoe that will be added to an order
     * @param scanner  scanner for taking in user input
     */
    private static void addToCart(Customer customer, Shoe shoe, Scanner scanner, Data data) {
        boolean editOrNew = editOrNew(scanner);
        if (editOrNew) {
            add(customer, shoe);
        } else {
            edit(customer, shoe, scanner, data);
        }
    }

    /**
     * adds a new order to the database
     *
     * @param customer customer that adds the order to the database
     * @param shoe     Shoe that will be added to the new order
     */
    private static void add(Customer customer, Shoe shoe) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                "root",// TODO: 23/02/2021 get username form properties file
                "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
            CallableStatement state = con.prepareCall("CALL addToCart(?,?,?)");
            state.setInt(1, customer.getId()); // customer that placed the new order
            state.setInt(2, NULL); // order id but its null so it creates a new order
            state.setInt(3, shoe.getId()); // shoe that is in the new order
            state.execute(); // executes the
            System.out.println("\nThe new order was placed :) ");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("\nThe order was not placed !!!!");
        }
    }

    /**
     * edits a pre existing order in the database
     *
     * @param customer customer that edits the order
     * @param shoe     Shoe that will be added to the order
     */
    private static void edit(Customer customer, Shoe shoe, Scanner scanner, Data data) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                "root", // TODO: 23/02/2021 get username form properties file
                "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
            System.out.println("\nInput order you wanna edit");
            while (true) {
                try {
                    int orderId = scanner.nextInt(); // TODO: 24/02/2021 change so that you select with name or something instead of id
                    if (orderId > data.orders.size()) {
                        System.out.println("\nOrder dose not yet exist\nPlease try again: ");
                    } else if (orderId <= 0) {
                        System.out.println("\nOrder dose not and will never exist\nPlease try again: ");
                    } else {
                        CallableStatement state = con.prepareCall("CALL addToCart(?,?,?)");
                        state.setInt(1, customer.getId()); // sets the customer tat placed the order
                        state.setInt(2, orderId); // order that will be edited
                        state.setInt(3, shoe.getId()); // sets the shoe that will be added to the order
                        state.execute(); // executes the state
                        System.out.println("\nThe shoe was added to the order :) ");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("input needs to be an existing order ");
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("\nThe order was not edited placed !!!!");
        }
    }

    /**
     * Returns the average rating of the Shoe
     *
     * @param shoe shoe whose average rating will be checked
     * @return average rating of the shoe
     */
    private static int averageRating(Shoe shoe) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                "root", // TODO: 23/02/2021 get username form properties file
                "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
            CallableStatement state = con.prepareCall("{ ? = CALL Average_Rating(?)}");
            state.registerOutParameter(1, INTEGER);
            state.setInt(2, shoe.getId()); // sets the shoe that will be added to the order
            state.execute(); // executes the state
            return state.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * gets the text form of
     *
     * @param averageRating average rating of the shoe, represented by a number
     * @return the string that represents the same rating but in text form
     */
    private static String averageRatingText(int averageRating, List<Rating> ratings) {
        if (averageRating == 0) {
            return null;
        } else {
            List<Rating> temp = ratings.stream()
                    .filter(rating -> rating.getnRating() == averageRating)
                    .collect(Collectors.toList());
            return temp.get(0).toString();
        }

    }

    /**
     * Rate and Comment on the shoe that the user just ordered
     *
     * @param user    the user that ordered something and will now rate and commented on
     * @param shoe    shoe that the user ordered and will now rate and be commented on
     * @param scanner scanner for taking in user input
     */
    private static void rateAndComment(Customer user, Shoe shoe, Scanner scanner, Data data) {

        System.out.println("\nRatings Are (Very Unsatisfied,Unsatisfied,OK,Great,Fantastic)");
        while (true) {
            String userRating = scanner.nextLine(); // takes in user input

            String comment;
            List<Rating> selectedRating = data.ratings.stream() //picks out all matching ratings into a list (Should only be one...)
                    .filter(rating -> rating.getRating().equalsIgnoreCase(userRating))
                    .collect(Collectors.toList());
            if (selectedRating.iterator().hasNext()) {
                int ratingId = selectedRating.get(0).getnRating();
                System.out.println("\nDo you wanna comment on the shoe? ");
                if (yesOrNO(scanner)) {
                    System.out.print("\nPlease type comment: ");
                    Scanner input = new Scanner(System.in); // needed to make another scanner for it to work for some yet unknown reason
                    comment = input.nextLine();
                } else {
                    comment = null;
                }
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                        "root", // TODO: 23/02/2021 get username form properties file
                        "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
                    CallableStatement state = con.prepareCall("CALL RateAndComment(?,?,?,?)");
                    state.setInt(1, user.getId());
                    state.setInt(2, shoe.getId()); // sets the shoe that will be added be rated and commented
                    state.setInt(3, ratingId);
                    state.setString(4, comment);
                    state.execute();
                    System.out.println("\nRating and commenting on the shoe succeeded");
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\nFailed to rate and comment on the product  ");
                    break;
                }
            } else {
                System.out.print("Please input a valid rating: ");
            }
        }
    }

    /**
     * Simple yes or no scanner check
     *
     * @return true for yes | no for false
     */
    private static boolean yesOrNO(Scanner scanner) {
        System.out.print("\nPlease input (yes/no): ");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes")) {
                return true;
            } else if (input.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.print("\nPlease input (yes/no): ");
            }
        }
    }

    /**
     * Lists the comments of the shoe
     *
     * @param shoe     shoe whose comments will be printed
     * @param comments list of all the comments
     */
    private static void listComments(Shoe shoe, List<Comment> comments) {
        List<Comment> filteredComments = comments.stream().filter(comment -> comment.getShoe().equals(shoe)).collect(Collectors.toList());
        if (filteredComments.isEmpty()) {
            System.out.println("\nThere has been no comments placed on this shoe yet");
        } else {
            filteredComments.forEach(comment -> System.out.println(comment.toString()));
        }
    }

    /**
     * Lists all the shoes that is in the order
     *
     * @param orders list of all the ordered shoes and what order they are associated in
     * @param order  order witch all the items will be listed from
     */
    private static void listOrder(List<IsIn> orders, Order order) {
        List<IsIn> temp = orders.stream().filter(isIn -> isIn.getOrder().equals(order)).collect(Collectors.toList());
        if (temp.isEmpty()) {
            System.out.println("there are no shoes in this order ? WUT ? ERROR");
        } else {
            temp.forEach(isIn -> System.out.println(isIn.getShoe().toString()));
        }
    }
}

