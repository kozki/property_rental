package si.fri.rso.rsobnb.property_rental.api.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import si.fri.rso.rsobnb.property_rental.api.configuration.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@Health
@ApplicationScoped
public class PropertyRentalServiceHealthCheck implements HealthCheck{

    @Inject
    private RestProperties restProperties;

    private Logger log = Logger.getLogger(PropertyRentalServiceHealthCheck.class.getName());

    @Override
    public HealthCheckResponse call() {

        if (restProperties.isHealthy()) {
            return HealthCheckResponse.named(PropertyRentalServiceHealthCheck.class.getSimpleName()).up().build();
        } else {
            return HealthCheckResponse.named(PropertyRentalServiceHealthCheck.class.getSimpleName()).down().build();
        }

    }
}