package org.Thisaru.storage;

import org.Thisaru.models.Author;
import org.Thisaru.models.Book;
import org.Thisaru.models.Cart;
import org.Thisaru.models.Customer;

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

}
