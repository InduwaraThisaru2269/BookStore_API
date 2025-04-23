package org.Thisaru;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/";

    public static HttpServer startServer() {
        final ResourceConfig config = new ResourceConfig().packages(
               "org.Thisaru.storage;","org.Thisaru.resources", "org.Thisaru.exceptions", "org.Thisaru.exceptions.mappers"
        );

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }

    public static void main(String[] args) {

        final HttpServer server = startServer();
        System.out.println("📘 Bookstore API started at: " + BASE_URI);
        System.out.println("👉 Press Enter to stop the server...");

        try {
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        server.shutdownNow();
        System.out.println("🛑 Server stopped.");
    }
}