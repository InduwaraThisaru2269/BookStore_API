package org.Thisaru.storage;

import org.Thisaru.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStorage {

    // --- Books ---
    private static final Map<Integer, Book> books = new HashMap<>();
    private static int bookIdCounter = 1;

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public static Book getBookById(int id) {
        return books.get(id);
    }

    public static Book addBook(Book book) {
        book.setId(bookIdCounter++);
        books.put(book.getId(), book);
        return book;
    }

    public static Book updateBook(int id, Book updatedBook) {
        updatedBook.setId(id);
        books.put(id, updatedBook);
        return updatedBook;
    }

    public static void deleteBook(int id) {
        books.remove(id);
    }

    public static boolean bookExists(int id) {
        return books.containsKey(id);
    }


    // --- Authors ---
    private static final Map<Integer, Author> authors = new HashMap<>();
    private static int authorIdCounter = 1;

    public static List<Author> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    public static Author getAuthorById(int id) {
        return authors.get(id);
    }

    public static Author addAuthor(Author author) {
        author.setId(authorIdCounter++);
        authors.put(author.getId(), author);
        return author;
    }

    public static Author updateAuthor(int id, Author updatedAuthor) {
        updatedAuthor.setId(id);
        authors.put(id, updatedAuthor);
        return updatedAuthor;
    }

    public static void deleteAuthor(int id) {
        authors.remove(id);
    }

    public static boolean authorExists(int id) {
        return authors.containsKey(id);
    }


    // -- Customers --
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static int customerIdCounter = 1;

    public static List<Customer> getAllCustomers(){
        return new ArrayList<>(customers.values());
    }

    public static Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public static Customer addCustomer(Customer customer) {
        customer.setId(customerIdCounter++);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public static Customer updateCustomer(int id, Customer updatedCustomer) {
        updatedCustomer.setId(id);
        customers.put(id, updatedCustomer);
        return updatedCustomer;
    }

    public static void deleteCustomer(int id) {
        customers.remove(id);
    }

    public static boolean customerExists(int id) {
        return customers.containsKey(id);
    }

    // -- Cart --

    private static final Map<Integer, Cart> carts = new HashMap<>();
    private static int cartIdCounter = 1;

    public static List<Cart> getAllCarts(){
        return new ArrayList<>(carts.values());
    }

    public static Cart getCartById(int id) {
        return carts.get(id);
    }

    public static Cart addCart(Cart cart) {
        cart.setId(cartIdCounter++);
        carts.put(cart.getId(), cart);
        return cart;
    }

    public static Cart updateCart(int id, Cart updatedCart) {
        updatedCart.setId(id);
        carts.put(id, updatedCart);
        return updatedCart;
    }

    public static void deleteCart(int id) {
        carts.remove(id);
    }

    public static boolean cartExists(int id) {
        return carts.containsKey(id);
    }


    // -- Orders --

    private static final Map<Integer, Order> orders = new HashMap<>();
    private static int orderIdCounter = 1;

    public static List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public static Order getOrderById(int id) {
        return orders.get(id);
    }

    public static Order addOrder(Order order) {
        order.setId(orderIdCounter++);
        orders.put(order.getId(), order);
        return order;
    }

    public static Order updateOrder(int id, Order updatedOrder) {
        updatedOrder.setId(id);
        orders.put(id, updatedOrder);
        return updatedOrder;
    }

    public static void deleteOrder(int id) {
        orders.remove(id);
    }

    public static boolean orderExists(int id) {
        return orders.containsKey(id);
    }
}
