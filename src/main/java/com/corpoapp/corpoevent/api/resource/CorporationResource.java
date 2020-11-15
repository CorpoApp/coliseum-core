package com.corpoapp.corpoevent.api.resource;

import com.corpoapp.corpoevent.api.dto.CorporationDTO;
import com.corpoapp.corpoevent.domain.service.CorporationService;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/corporation")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @Inject
    CorporationService corporationService;

    @GET
    public List<CorporationDTO> getAll() {
        return corporationService.getAll();
    }

    @POST
    public Response create(@QueryParam String name, @QueryParam String sport) {
        corporationService.create(name, sport);
        return Response.status(201).build();
    }
}