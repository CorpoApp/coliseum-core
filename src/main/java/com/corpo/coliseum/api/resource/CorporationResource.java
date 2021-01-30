package com.corpo.coliseum.api.resource;

import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.CorporationService;
import com.corpo.coliseum.api.dto.CorporationDTO;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("/corporation")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @Inject
    CorporationService corporationService;

    @Inject
    ModelMapper modelMapper;

    @GET
    public List<CorporationDTO> getAll() {
        return corporationService.getAll()
                .stream()
                .map(corporation -> modelMapper.map(corporation, CorporationDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    public Response create(@Valid CorporationDTO corporationDTO, @Context UriInfo uriInfo) {
        corporationService.create(modelMapper.map(corporationDTO, Corporation.class));
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(corporationDTO.getName());
        return Response.created(uriBuilder.build()).build();
    }

    @DELETE
    public Response delete(@QueryParam("name") String name) throws ModelNotFoundException {
        corporationService.remove(name);
        return Response.noContent().build();
    }
}
