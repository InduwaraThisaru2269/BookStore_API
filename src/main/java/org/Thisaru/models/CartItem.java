package org.Thisaru.models;

public class CartItem {
    private int bookId;
    private int noOfBooks;

    public CartItem() {}
    public CartItem(int bookId, int noOfBooks) {
        this.bookId = bookId;
        this.noOfBooks = noOfBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
}
