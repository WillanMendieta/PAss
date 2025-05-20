package test.quarkus.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.Json;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import test.quarkus.client.PokemonClient;
import test.quarkus.dto.Request;

@Slf4j
@Path("/api")
public class GreetingResource {

    @RestClient
    PokemonClient client;

    @POST
    @Path("v1/test")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response test1(String requestStr) {
        log.info("Ingreso: {}", requestStr);

        Request request = Json.decodeValue(requestStr, Request.class);

        if (request.getParam1() == null || request.getParam1().trim().isEmpty() ||
                request.getParam2() == null || request.getParam2().trim().isEmpty() ||
                request.getParam3() == null || request.getParam3().trim().isEmpty() ||
                request.getParam4() == null || request.getParam4().trim().isEmpty() ||
                request.getParam5() == null || request.getParam5().trim().isEmpty()) {

            String jsonError = "{\"error\": \"Todos los parámetros deben estar presentes y no vacíos\"}";
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(jsonError)
                    .build();
        }

        String p1 = request.getParam1().replaceAll("['\";\\\\]", "").replaceAll("--", "");
        String p2 = request.getParam2().replaceAll("['\";\\\\]", "").replaceAll("--", "");
        String p3 = request.getParam3().replaceAll("['\";\\\\]", "").replaceAll("--", "");
        String p4 = request.getParam4().replaceAll("['\";\\\\]", "").replaceAll("--", "");
        String p5 = request.getParam5().replaceAll("['\";\\\\]", "").replaceAll("--", "");

        return Response.ok(
                String.format("Result: %s, %s, %s, %s, %s", p1, p2, p3, p4, p5),
                MediaType.TEXT_PLAIN
        ).build();
    }

    @GET
    @Path("v2/move")
    public String test2(){
        log.info("Petición a cliente");
        return client.sendRequest();
    }

}
