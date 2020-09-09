package dev.marcel.localidade.model.ibge.feign;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dev.marcel.localidade.model.ibge.feign.dto.EstadoDto;
import dev.marcel.localidade.model.ibge.feign.dto.MunicipioDto;

public interface IBGEFeignService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("estados")
    List<EstadoDto> getEstados();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("municipios/{id]}")
    MunicipioDto findMunicipio(@PathParam("id") final Long id);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("estados/{uf}/municipios")
    List<MunicipioDto> getMunicipios(@PathParam("uf") final Long uf);
}
