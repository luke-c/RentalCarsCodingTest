package rest;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luke_c on 26/04/2017.
 */

// Code taken from https://github.com/jersey/jersey/tree/2.24/examples/helloworld-pure-jax-rs
public class JaxRsApplication extends Application {
    private final Set<Class<?>> classes;

    public JaxRsApplication() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(RentalCarsResource.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}