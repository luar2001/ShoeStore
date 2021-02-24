import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.sql.Types.INTEGER;
import static java.sql.Types.NULL;


/**
 * Created by Lukas Aronsson
 * Date: 20/02/2021
 * Time: 17:35
 * Project: ShoeStore
 * Copyright: MIT
 **/
public class ShoeStore {
    /**
     * Main methods that start the program
     *
     * @param args argument of some kind.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner
        new Data(); // takes in the data from the database and make the tables into objects and then put them in lists

        //  Data.customers.forEach(customer -> System.out.println(customer.getUsername())); //Test string that print all usernames
        //  Data.customers.forEach(customer -> System.out.println(customer.getPassword())); //test string that prints all passwords

        //login
        Customer user = login(Data.customers, scanner);
        System.out.println("Welcome " + user);

        //prints list of all the shoes
        System.out.println("\nBrand Color Size Price Average Rating");
        //user input
        Shoe shoe = selectShoe(Data.shoes, scanner);

        //add to order / order shoe
        addToCart(user, shoe, scanner);
        System.out.println("\nWanna see whats in your order?");
        boolean yesOrNO = yesOrNO(scanner);
        if (yesOrNO) {
            System.out.println("NOTHING HERE YET"); // TODO: 23/02/2021 show all the shoes in the order'
        }

        //rate and comment
        System.out.print("\nWanna rate and comment on the shoe?");
        boolean yesOrNO1 = yesOrNO(scanner);
        if (yesOrNO1) {
            rateAndComment(user, shoe, scanner);
        }

        System.out.print("\nWanna see the shoes comments?");
        boolean yesOrNO2 = yesOrNO(scanner);
        if (yesOrNO2) {
            listComments(shoe, Data.comments);
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
    private static Customer login(List<Customer> customers, Scanner scanner) { // TODO: 23/02/2021 fix login for other accounts then username (tex username1 or username2)
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
    private static Shoe selectShoe(List<Shoe> shoes, Scanner scanner) { // TODO: 24/02/2021 Only let it select shoes that's in stock
        System.out.println("\nChores a Shoe by typing a number ");

        List<Shoe> availableShoes = shoes.stream()
                .filter(shoe -> shoe.getAmount() > 0).collect(Collectors.toList());
        availableShoes.forEach(shoe -> System.out.println(shoe.getId() + " " + shoe.toString() + " " + averageRating(shoe) + " " + averageRatingText(averageRating(shoe), Data.ratings)));

        while (true) {
            try {
                int input = scanner.nextInt(); // TODO: 23/02/2021 change so that you select with name or something instead of id
                if (availableShoes.stream().findAny().filter(shoe -> shoe.getId() == input).isPresent()) {
                    System.out.println("\n" + shoes.get(input - 1).toString()); //prints out witch shoe the user selected
                    return shoes.get(input - 1);
                } else {
                    System.out.println("\nPlease input the id of a shoe from the list: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nYou need to input a number that represents a shoe ");
            } catch (IndexOutOfBoundsException g) {
                System.out.println("\nYou need to input a number that represents a shoe that exists ");
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
    private static void addToCart(Customer customer, Shoe shoe, Scanner scanner) {
        boolean editOrNew = editOrNew(scanner);
        if (editOrNew) {
            add(customer, shoe);
        } else {
            edit(customer, shoe, scanner);
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
    private static void edit(Customer customer, Shoe shoe, Scanner scanner) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                "root", // TODO: 23/02/2021 get username form properties file
                "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
            System.out.println("\nInput order you wanna edit");
            while (true) {
                try {
                    int orderId = scanner.nextInt();
                    if (orderId > Data.orders.size()) {
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
    private static void rateAndComment(Customer user, Shoe shoe, Scanner scanner) {
        System.out.print("\nPlease input rating: ");
        int rating = scanner.nextInt(); // TODO: 24/02/2021 make this one select by rating instead of rating id also make it a while loop
        String comment = null;
        System.out.println("\nDo you wanna comment ? ");
        if (yesOrNO(scanner)) {
            System.out.print("\nPlease input Comment: ");
            comment = scanner.next();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false", // TODO: 23/02/2021 get connection string form properties file
                "root", // TODO: 23/02/2021 get username form properties file
                "U4C~cZ55Vi9ekW^L%k8b")) { // TODO: 23/02/2021 get password form properties file
            CallableStatement state = con.prepareCall("{CALL RateAndComment(?,?,?,?)}");
            state.setInt("InCustomerID", user.getId());
            state.setInt("InShoeID", shoe.getId()); // sets the shoe that will be added be rated and commented
            state.setInt("InRatingID", rating);
            state.setString("InComment", comment);
        } catch (Exception e) {
            e.printStackTrace();
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
            String input = scanner.next().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
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
}

