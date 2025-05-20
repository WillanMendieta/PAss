package test.quarkus.interceptor;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingInterceptor implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        System.out.println(">>> Entrada:");
        System.out.println("Método: " + requestContext.getMethod());
        System.out.println("Path: " + requestContext.getUriInfo().getPath());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        System.out.println("<<< Salida:");
        System.out.println("Status: " + responseContext.getStatus());
        System.out.println("Entidad: " + responseContext.getEntity());
    }
}
