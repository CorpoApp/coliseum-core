package com.corpoapp.corpoevent.api;

import com.corpoapp.corpoevent.entity.Corporation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/corporation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @GET
    public List<Corporation> list() {
        return Corporation.listAll();
    }

    @POST
    public Corporation add(Corporation corporation) {
        Corporation.persist(corporation);
        return corporation;
    }
}
