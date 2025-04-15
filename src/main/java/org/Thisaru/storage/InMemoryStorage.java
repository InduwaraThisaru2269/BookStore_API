package org.Thisaru.storage;

import org.Thisaru.models.Book;

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
}
