package hu.javagladiators.apps.heroesofempires.hero.rest;

import hu.javagladiators.apps.heroesofempires.hero.model.Hero;
import hu.javagladiators.apps.heroesofempires.hero.model.HeroService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("data")
public class HeroResource {
    
    @Inject
    HeroService service;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getAll() {
        return service.getMoreOrderByKey(0, service.getSize());
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hero getById(@PathParam("name") String pName) {
        return service.getByKey(pName);
    }

    @GET
    @Path("/{offset}/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getmore(@PathParam("offset") int pOffset, @PathParam("offset") long pLimit) {
        return service.getMoreOrderByKey(pOffset, pLimit);
    }
    
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("name") String pName) {
        try{
            service.deleteByKey(pName);
            return Response.ok(pName).build();
        }
        catch(Exception e){ return Response.status(Response.Status.NOT_FOUND).build();}
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(
            @FormParam("name") String pName,
            @FormParam("desc") String pDesc,
            @FormParam("avail") String pAvail
    ){
        try{
            service.add(new Hero(pName, pDesc, pAvail!=null));
            return Response.ok(pName).build();
        }
        catch(Exception e){ return Response.status(Response.Status.NOT_FOUND).build();}
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(
            @PathParam("name") String pOldName,
            @FormParam("name") String pName,
            @FormParam("desc") String pDesc,
            @FormParam("avail") String pAvail
    ){
        try{
            service.modify(pOldName,new Hero(pName, pDesc, pAvail!=null));
            return Response.ok(pName).build();
        }
        catch(Exception e){ return Response.status(Response.Status.NOT_FOUND).build();}
    }
    
}
