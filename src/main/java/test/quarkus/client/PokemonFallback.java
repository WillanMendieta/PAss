package test.quarkus.client;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PokemonFallback implements PokemonClient {

    @Override
    public String sendRequest() {
        return "Fallback: Servicio no disponible en este momento";
    }
}
