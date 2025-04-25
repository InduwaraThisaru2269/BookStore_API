package org.Thisaru.resources;

import org.Thisaru.exceptions.BookNotFoundException;
import org.Thisaru.exceptions.CartNotFoundException;
import org.Thisaru.exceptions.OutOfStockException;
import org.Thisaru.models.Book;
import org.Thisaru.models.Cart;
import org.Thisaru.models.CartItem;
import org.Thisaru.storage.InMemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    @PathParam("customerId")
    private int customerId;

    @GET
    public Response getCart() {
        Cart cart = validateAndGetCart(customerId);
        return Response.ok(cart).build();
    }

    @POST
    @Path("/items")
    public Response addItemToCart(List<CartItem> newItems) {
        Cart cart = null;

        for(Cart c: InMemoryStorage.getAllCarts()) {
            if(c.getCustomerId() == customerId && !c.isOrdered()) {
                cart = c;
                break;
            }
        }

        if(cart == null) {
            cart = new Cart(0, customerId, new ArrayList<>(), false);
            cart = InMemoryStorage.addCart(cart);
        }

        for (CartItem newItem : newItems) {
            boolean itemFound = false;

            for (CartItem existingItem : cart.getItems()) {
                if (existingItem.getBookId() == newItem.getBookId()) {
                    existingItem.setNoOfBooks(existingItem.getNoOfBooks() + newItem.getNoOfBooks());
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                cart.getItems().add(newItem);
            }
        }

        return Response.status(Response.Status.CREATED).entity(cart).build();
    }


    @PUT
    @Path("/items/{bookId}")
    public Response updateCartItem(@PathParam("bookId") int bookId, CartItem updatedItem) {
        Cart cart = validateAndGetCart(customerId);

        Book book = validateAndGetBook(bookId);

        if (updatedItem.getNoOfBooks() > book.getStockQuantity()) {
            throw new OutOfStockException("Not enough stock for book ID " + bookId);
        }

        for (CartItem item : cart.getItems()) {
            if (item.getBookId() == bookId) {
                item.setNoOfBooks(updatedItem.getNoOfBooks());
                return Response.ok(cart).build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Item not found in cart").build();
    }

    @DELETE
    @Path("/items/{bookId}")
    public Response deleteCartItem(@PathParam("bookId") int bookId) {
        Cart cart = validateAndGetCart(customerId);

        validateAndGetBook(bookId);

        List<CartItem> updatedItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getBookId() != bookId) {
                updatedItems.add(item);
            }
        }

        cart.setItems(updatedItems);
        return Response.ok(cart).build();
    }


    // Helper methods for reduce duplicates
    private Cart validateAndGetCart(int customerId) {
        for (Cart c : InMemoryStorage.getAllCarts()) {
            if (c.getCustomerId() == customerId && !c.isOrdered()) {
                return c;
            }
        }
        throw new CartNotFoundException("No cart found for customer ID: " + customerId);
    }

    private Book validateAndGetBook(int bookId) {
        Book book = InMemoryStorage.getBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        return book;
    }


}
