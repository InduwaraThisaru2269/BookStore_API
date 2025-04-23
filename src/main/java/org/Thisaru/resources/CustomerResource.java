package org.Thisaru.resources;

import org.Thisaru.exceptions.CustomerNotFoundException;
import org.Thisaru.models.Customer;
import org.Thisaru.storage.InMemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @POST
    public Response createCustomer(Customer customer) {
        if(customer.getName() == null || customer.getName().trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid Input\", \"message\": \"Title is required.\"}")
                    .build();
        }

        Customer created = InMemoryStorage.addCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    public Response getAllCustomers() {
        List<Customer> customers = InMemoryStorage.getAllCustomers();
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException("No Customers found in storage");
        }
        return Response.ok(customers).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = InMemoryStorage.getCustomerById(id);
        if(customer == null) {
            throw new CustomerNotFoundException("Customer with Id: "+id+" is not found");
        }
        return Response.ok(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") int id, Customer customer) {
        if (!InMemoryStorage.customerExists(id)) {
            throw new CustomerNotFoundException("Customer with Id: " + id + " not found.");
        }
        Customer updatedCustomer = InMemoryStorage.updateCustomer(id, customer);
        return Response.ok(updatedCustomer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        if (!InMemoryStorage.customerExists(id)) {
            throw new CustomerNotFoundException("Customer with Id: " + id + " not found.");
        }

        InMemoryStorage.deleteCustomer(id);
        return Response.ok().build();
    }
}
