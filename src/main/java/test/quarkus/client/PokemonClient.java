package test.quarkus.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Fallback;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "pokemon")
@Timeout(2000)
@Retry(maxRetries = 3)
@Fallback(PokemonFallback.class)
public interface PokemonClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String sendRequest();

}
