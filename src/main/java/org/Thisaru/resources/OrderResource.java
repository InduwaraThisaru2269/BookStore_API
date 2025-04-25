package org.Thisaru.resources;

import org.Thisaru.models.Book;
import org.Thisaru.models.Cart;
import org.Thisaru.models.CartItem;
import org.Thisaru.models.Order;
import org.Thisaru.storage.InMemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @PathParam("customerId")
    private int customerId;

    @GET
    public Response getAllOrdersForCustomer() {
        List<Order> orders = new ArrayList<>();

        for(Order o : InMemoryStorage.getAllOrders()) {
            if(o.getCustomerId() == customerId) {
                orders.add(o);
            }
        }

        if (orders.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"No Orders\", \"message\": \"No Orders found for given Customer Id\"}")
                    .build();
        }

        return Response.ok(orders).build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrderById(@PathParam("orderId") int orderId) {
        Order order = InMemoryStorage.getOrderById(orderId);

        if(order == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"No Order\", \"message\": \"No Order found for given order Id\"}")
                    .build();
        }

        return Response.ok(order).build();
    }


    @POST
    public Response placeOrder() {
        List<Cart> customerCarts = new ArrayList<>();

        for(Cart c : InMemoryStorage.getAllCarts()) {
            if(c.getCustomerId() == customerId) {
                customerCarts.add(c);
            }
        }

        if (customerCarts.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"No Carts\", \"message\": \"No valid cart found for this customer\"}")
                    .build();
        }

        if (customerCarts.size() > 1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Multiple Carts\", \"message\": \"Multiple carts found for this customer\"}")
                    .build();
        }

        Cart cart = customerCarts.get(0);
        double totalPrice = calculateTotalPrice(cart.getItems());

        Order newOrder = new Order(0, customerId, cart.getItems(), totalPrice);
        InMemoryStorage.addOrder(newOrder);

        cart.setOrdered(true);
        InMemoryStorage.updateCart(cart.getId(), cart);

        return Response.status(Response.Status.CREATED).entity(newOrder).build();
    }

    private double calculateTotalPrice(List<CartItem> items) {
        double total = 0;
        for(CartItem item: items) {
            Book book = InMemoryStorage.getBookById(item.getBookId());
            if(book != null) {
                total += book.getPrice() * item.getNoOfBooks();
                book.setStockQuantity(book.getStockQuantity() - item.getNoOfBooks());
            }
        }

        return total;
    }
}
