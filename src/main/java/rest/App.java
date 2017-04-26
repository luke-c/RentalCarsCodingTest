package rest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Created by luke_c on 26/04/2017.
 */

// Code taken from https://github.com/jersey/jersey/tree/2.24/examples/helloworld-pure-jax-rs
public class App {

    static HttpServer startServer() throws IOException {
        // create a new server listening at port 8080
        final HttpServer server = HttpServer.create(new InetSocketAddress(getBaseURI().getPort()), 0);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.stop(0);
            }
        }));

        // create a handler wrapping the JAX-RS application
        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new JaxRsApplication(), HttpHandler.class);

        // map JAX-RS handler to the server root
        server.createContext(getBaseURI().getPath(), handler);

        // start the server
        server.start();

        return server;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("RentalCars RESTful Application");

        startServer();

        System.out.println("Application started.\n"
                + "Try accessing one of the following:\n"
                + getBaseURI() + "rentalcars/price\n"
                + getBaseURI() + "rentalcars/specificationJson.txt\n"
                + getBaseURI() + "rentalcars/rating\n"
                + getBaseURI() + "rentalcars/score");

        Thread.currentThread().join();
    }

    private static int getPort(int defaultPort) {
        final String port = System.getProperty("jersey.config.test.container.port");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
                System.out.println("Value of jersey.config.test.container.port property"
                        + " is not a valid positive integer [" + port + "]."
                        + " Reverting to default [" + defaultPort + "].");
            }
        }
        return defaultPort;
    }

    public static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build();
    }
}