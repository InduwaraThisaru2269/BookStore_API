package org.Thisaru.resources;

import org.Thisaru.exceptions.AuthorNotFoundException;
import org.Thisaru.exceptions.BookNotFoundException;
import org.Thisaru.models.Book;
import org.Thisaru.storage.InMemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @POST
    public Response createBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid Input\", \"message\": \"Title is required.\"}")
                    .build();
        }
        boolean isAuthorExists = InMemoryStorage.authorExists(book.getAuthorId());

        if(!isAuthorExists) {
            throw new AuthorNotFoundException("Author with Id "+book.getAuthorId()+" is not found.");
        }
        Book created = InMemoryStorage.addBook(book);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    public Response getAllBooks() {
        List<Book> books = InMemoryStorage.getAllBooks();
        if(books.isEmpty()) {
            throw new BookNotFoundException("No books found in storage");
        }
        return Response.ok(books).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id) {
        Book book = InMemoryStorage.getBookById(id);
        if(book == null) {
            throw new BookNotFoundException("Book with Id: "+id+" is not found");
        }
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Book book) {
        if (!InMemoryStorage.bookExists(id)) {
            throw new BookNotFoundException("Book with Id: " + id + " not found.");
        }
        boolean isAuthorExists = InMemoryStorage.authorExists(book.getAuthorId());

        if(!isAuthorExists) {
            throw new AuthorNotFoundException("Author with Id "+book.getAuthorId()+" is not found.");
        }
        Book updatedBook = InMemoryStorage.updateBook(id, book);
        return Response.ok(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        if (!InMemoryStorage.bookExists(id)) {
            throw new BookNotFoundException("Book with Id: " + id + " not found.");
        }

        InMemoryStorage.deleteBook(id);
        return Response.ok().build();
    }
}
