package org.Thisaru.exceptions.mappers;

import org.Thisaru.exceptions.OutOfStockException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class OutOfStockMapper implements ExceptionMapper<OutOfStockException> {

    @Override
    public Response toResponse(OutOfStockException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Out Of Stock");
        error.put("message", ex.getMessage());

        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}