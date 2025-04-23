package org.Thisaru.resources;

import org.Thisaru.exceptions.AuthorNotFoundException;
import org.Thisaru.models.Author;
import org.Thisaru.storage.InMemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @POST
    public Response createAuthor(Author author) {
        if(author.getName() == null || author.getName().trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid Input\", \"message\": \"Author name is required.\"}")
                    .build();
        }

        Author created = InMemoryStorage.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    public Response getAllAuthors() {
        List<Author> authors = InMemoryStorage.getAllAuthors();
        if(authors.isEmpty()) {
            throw new AuthorNotFoundException("No authors found in storage");
        }
        return Response.ok(authors).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        Author author = InMemoryStorage.getAuthorById(id);
        if(author == null) {
            throw new AuthorNotFoundException("Author with Id: " + id + " is not found");
        }
        return Response.ok(author).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") int id, Author author) {
        if (!InMemoryStorage.authorExists(id)) {
            throw new AuthorNotFoundException("Author with Id: " + id + " not found.");
        }
        Author updatedAuthor = InMemoryStorage.updateAuthor(id, author);
        return Response.ok(updatedAuthor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") int id) {
        if (!InMemoryStorage.authorExists(id)) {
            throw new AuthorNotFoundException("Author with Id: " + id + " not found.");
        }

        InMemoryStorage.deleteAuthor(id);
        return Response.ok().build();
    }
}

