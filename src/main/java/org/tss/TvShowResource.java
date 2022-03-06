package org.tss;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.panache.common.Page;

@Path("/api/tvshow")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TvShowResource {
    
    @Inject
    TvShowRespository tvShowRespository;

    @GET
    @Path("/{title}")
    public TvShow findBy(@PathParam("title") String title) {
        return tvShowRespository.findByTitle(title);
    }

    @GET
    public List<TvShow> findAll(@DefaultValue("2") @QueryParam("pageSize") int pageSize) {
        return tvShowRespository.findAll().page(Page.ofSize(pageSize)).list();
    } 

    @POST
    @Transactional
    public Response create(@Valid TvShow tvShow) {
        tvShow.id = null;
        tvShow.persist();
        return Response.status(Response.Status.CREATED).entity(tvShow).build();
    }
}
