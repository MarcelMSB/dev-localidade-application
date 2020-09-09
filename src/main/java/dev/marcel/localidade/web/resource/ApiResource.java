package dev.marcel.localidade.web.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

import dev.marcel.localidade.web.resource.ibge.IBGEResource;

@Path("api")
public class ApiResource {

    @Inject
    private IBGEResource ibgeResource;

    @Path("ibge")
    public IBGEResource ibge() {
        return ibgeResource;
    }
}
