package org.Thisaru.exceptions.mappers;

import org.Thisaru.exceptions.CustomerNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class CustomerNotFoundMapper implements ExceptionMapper<CustomerNotFoundException> {
    @Override
    public Response toResponse(CustomerNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Customer Not Found");
        error.put("message", ex.getMessage());

        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
