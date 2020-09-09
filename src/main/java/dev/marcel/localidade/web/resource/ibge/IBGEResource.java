package dev.marcel.localidade.web.resource.ibge;

import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.marcel.localidade.model.ibge.feign.IBGEApiRemoteService;

@Stateless
public class IBGEResource {

    private static final String HEADER_VALUE_CACHE_CONTROL = "no-cache, no-store, must-revalidate";
    private static final String HEADER_VALUE_PRAGMA = "no-cache";

    @Inject
    private IBGEApiRemoteService service;

    @GET
    @Path("estados")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEstados() {
        return Response.ok(service.getEstados()).build();
    }
    
    @GET
    @Path("municipios/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMunicipio(@PathParam("id") final Long id) {
        return Response.ok(service.findNomeMunicipio(id)).build();
    }
    
    @GET
    @Path("municipios/csv")
    public Response findCSV() {
        byte[] teste = service.getMunicipiosCSV();
        return Response
                .ok((StreamingOutput) output -> output.write(teste))
                .type("text/html")
                .header(HttpHeaders.CACHE_CONTROL, IBGEResource.HEADER_VALUE_CACHE_CONTROL)
                .header("Pragma", IBGEResource.HEADER_VALUE_PRAGMA)
                .header(HttpHeaders.EXPIRES, "0")
                .header(HttpHeaders.CONTENT_LENGTH, teste.length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=municipios.csv")
                .build();
    }
    
    @GET
    @Path("municipios/json")
    public Response findJSON() throws JsonProcessingException {
        byte[] teste = service.getMunicipiosJSON();
        return Response
                .ok((StreamingOutput) output -> output.write(teste))
                .type("text/html")
                .header(HttpHeaders.CACHE_CONTROL, IBGEResource.HEADER_VALUE_CACHE_CONTROL)
                .header("Pragma", IBGEResource.HEADER_VALUE_PRAGMA)
                .header(HttpHeaders.EXPIRES, "0")
                .header(HttpHeaders.CONTENT_LENGTH, teste.length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=municipios.json")
                .build();
    }
}
