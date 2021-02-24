import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by Lukas Aronsson
 * Date: 22/02/2021
 * Time: 20:30
 * Project: ShoeStore
 * Copyright: MIT
 */

/**
 * Data takes in all the data and makes them into there respective object then stores them in a list
 * <p>
 * Data has
 * brands: list of all the Brand objects
 * colors: list of all the Color objects
 * shoes: list of all the Shoe objects
 * categories: list of all the Category objects
 * belongs: list of all the Belong objects
 * locations: list of all the Location objects
 * customers: list of all the Customer objects
 * orders: list of all the Orders objects
 * isIns: list of all the IsIn Objects
 * outOfStocks: list of all the OutOfStock objects
 * ratings: list of all the Rating objects
 * ratingsList: list of all the Ratings objects
 * comments: list of all the Comment objects
 */
public class Data {

    //Class.forName("com.mysql.jdbc.Driver"); // if you have problems with the mysql driver class not loading
    private static final String username = "root"; // username for mysql -- move to a properties file later // TODO: 23/02/2021 get username form properties file
    private static final String password = "U4C~cZ55Vi9ekW^L%k8b"; // password for mysql -- move to a properties file later // TODO: 23/02/2021 get password form properties file
    //Lists of all the data
    public List<Brand> brands = new ArrayList<>(); // brands: list of all the Brand objects
    public List<Color> colors = new ArrayList<>(); // colors: list of all the Color objects
    public List<Shoe> shoes = new ArrayList<>(); // shoes: list of all the Shoe objects
    public List<Category> categories = new ArrayList<>(); // categories: list of all the Category objects
    public List<Belong> belongs = new ArrayList<>(); // belongs: list of all the Belong objects
    public List<Location> locations = new ArrayList<>(); // locations: list of all the Location objects
    public List<Customer> customers = new ArrayList<>(); // customers: list of all the Customer objects
    public List<Order> orders = new ArrayList<>(); // orders: list of all the Orders objects
    public List<IsIn> isIns = new ArrayList<>(); // isIns: list of all the IsIn Objects
    public List<OutOfStock> outOfStocks = new ArrayList<>(); // outOfStocks: list of all the OutOfStock objects
    public List<Rating> ratings = new ArrayList<>(); // ratings: list of all the Rating objects
    public List<Ratings> ratingsList = new ArrayList<>(); // ratingsList: list of all the Ratings objects
    public List<Comment> comments = new ArrayList<>(); // comments: list of all the Comment objects
    private Statement state; //shorts the methods
    private ResultSet rs; //shorts the methods

    /**
     * Constructor for the Data Class that calls all the methods
     */
    public Data() {
        dataBrands();
        dataColors();
        dataShoes();
        dataCategories();
        dataBelongs();
        dataLocations();
        dataCustomers();
        dataOrders();
        dataIsIns();
        dataOutOfStocks();
        dataRatings();
        dataRatingsList();
        dataComments();
    }

    /**
     * updates the objects that will be called for during the programs execution
     */
    public void update() {
        //these are the only ones that need to be updated during the execution of the program therefore its okay to delete them all and add new ones
        //updates orders
        orders.clear();
        dataOrders();
        //updates IsIns
        isIns.clear();
        dataIsIns();
        //updates comments
        comments.clear();
        dataComments();
    }

    /**
     * Creates objects and puts them in a list of the type Brand
     */
    private void dataBrands() {
        //Gets the brands form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Brands");
            while (rs.next()) {
                Brand temp = new Brand(rs.getInt("id"), rs.getString("brand"));
                brands.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Color
     */
    private void dataColors() {
        //Gets the colors form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Colors");
            while (rs.next()) {
                Color temp = new Color(rs.getInt("id"), rs.getString("color"));
                colors.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Shoe
     */
    private void dataShoes() {
        //Gets the shoes from the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Shoes");
            while (rs.next()) {
                Shoe temp = new Shoe(); //Creates a temporary shoe
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setAmount(rs.getInt("Amount"));
                temp.setBrand(brands.get(rs.getInt("brand") - 1));
                temp.setColor(colors.get(rs.getInt("color") - 1));
                temp.setPrice(rs.getInt("Price"));
                temp.setSize(rs.getInt("Size"));
                shoes.add(temp); //adds the temp shoe to the shoes list
            }
        } catch (Exception s) {
            s.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Category
     */
    private void dataCategories() {
        //Gets the categories form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                Category temp = new Category(rs.getInt("id"), rs.getString("category"));
                categories.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Belong
     */
    private void dataBelongs() {
        //Gets the Belongs form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM BelongsIn");
            while (rs.next()) {
                Belong temp = new Belong(rs.getInt("id"),
                        shoes.get(rs.getInt("shoe") - 1),
                        categories.get(rs.getInt("category") - 1));
                belongs.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Location
     */
    private void dataLocations() {
        //Gets the locations form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Locations");
            while (rs.next()) {
                Location temp = new Location(rs.getInt("id"), rs.getString("location"));
                locations.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Customer
     */
    private void dataCustomers() {
        //Gets the customers form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Customers");
            while (rs.next()) {
                Customer temp = new Customer(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("username"),
                        rs.getString("password"),
                        locations.get(rs.getInt("location") - 1)
                );
                customers.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Order
     */
    private void dataOrders() {
        //Gets the orders form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Orders");
            while (rs.next()) {
                Order temp = new Order(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        customers.get(rs.getInt("CustomerID") - 1)
                );
                orders.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type IsIn
     */
    private void dataIsIns() {
        //Gets the isIns form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM IsIn");
            while (rs.next()) {
                IsIn temp = new IsIn(
                        rs.getInt("id"),
                        orders.get(rs.getInt("orderId") - 1),
                        shoes.get(rs.getInt("shoe") - 1)
                );
                isIns.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type OutOfStock
     */
    private void dataOutOfStocks() {
        //Gets the outOfStocks form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM OutOfStock");
            while (rs.next()) {
                OutOfStock temp = new OutOfStock(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        shoes.get(rs.getInt("shoe") - 1)
                );
                outOfStocks.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Rating
     */
    private void dataRatings() {
        //Gets the ratings form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Ratings");
            while (rs.next()) {
                Rating temp = new Rating(
                        rs.getInt("id"),
                        rs.getString("rating"),
                        rs.getInt("nRating")
                );
                ratings.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Ratings
     */
    private void dataRatingsList() {
        //Gets the ratingList form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Rating");
            while (rs.next()) {
                Ratings temp = new Ratings(
                        rs.getInt("id"),
                        shoes.get(rs.getInt("shoe") - 1),
                        ratings.get(rs.getInt("rating") - 1),
                        customers.get(rs.getInt("CustomerID") - 1)
                );
                ratingsList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates objects and puts them in a list of the type Comment
     */
    private void dataComments() {
        //Gets the comments form the database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore?serverTimezone=UTC&useSSL=false",
                username,
                password)) {
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM Comments");
            while (rs.next()) {
                Comment temp = new Comment(
                        rs.getInt("id"),
                        rs.getString("Comment"),
                        shoes.get(rs.getInt("shoe") - 1),
                        customers.get(rs.getInt("CustomerID") - 1)
                );
                comments.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
