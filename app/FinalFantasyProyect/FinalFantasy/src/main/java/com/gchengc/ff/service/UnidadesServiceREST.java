package com.gchengc.ff.service;

import com.gchengc.ff.model.UnidadesModel;
import com.google.gson.Gson;

import javax.persistence.EntityManager;

import javax.ejb.Stateless;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
@Path("units")
public class UnidadesServiceREST extends AbstractFacade<UnidadesModel> {

    private static EntityManager em;
    private Response.ResponseBuilder rp = null;
    private UnidadesModel unit;
    private List<UnidadesModel> units;

    public UnidadesServiceREST() {
        super(UnidadesModel.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(UnidadesModel entity) {
        try {
            System.out.println("Estoy en Rest");
            if ((boolean) super.create(entity)) {
                return Response.status(Response.Status.CREATED)
                        .entity(entity)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "POST")
                        .allow("OPTIONS").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "POST")
                        .allow("OPTIONS").build();
            }
        } catch (Exception e) {
            return Response.serverError()
                    .entity(e.getMessage())
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST")
                    .allow("OPTIONS").build();
        }
        //Gson gson = new Gson();
        //Type listType = new TypeToken<List<UnidadesModel>>(){}.getType();
        //List<UnidadesModel> units = gson.fromJson(entitys, listType);
        //for ( UnidadesModel unit: units){

        //return "OK";
        //}
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") long id) {
        try {
            this.unit = new UnidadesModel();
            this.unit = super.find(id);
            if (unit != null) {
                return Response.ok()
                        .entity(unit)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .allow("OPTIONS").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .allow("OPTIONS").build();
            }
        } catch (Exception e) {
            return Response.serverError()
                    .entity(e.getMessage())
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .allow("OPTIONS").build();
        }
    }

/*@GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<UnidadesModel> findAll() {
        return super.findAll();
    }*/

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        try {
            Object ob = super.findAll();
            if (ob != null) {
                return Response.ok().entity(new Gson().toJson(ob))
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .allow("OPTIONS").build();
            } else {
                return Response.noContent()
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .allow("OPTIONS").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage())
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .allow("OPTIONS").build();
        }

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, UnidadesModel entity) {
        try {
            if ((boolean) super.edit(entity)) {
                return Response.ok()
                        .entity(entity)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "PUT")
                        .allow("OPTIONS").build();
            } else {
                return Response.noContent()
                        .entity(entity)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "PUT")
                        .allow("OPTIONS").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage())
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "PUT")
                    .allow("OPTIONS").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        try {
            this.unit = new UnidadesModel();
            this.unit = super.find(id);

            if (unit != null) {
                if ((boolean) super.remove(unit)) {
                    return Response.ok()
                            .entity(unit)
                            .header("Access-Control-Allow-Origin", "*")
                            .header("Access-Control-Allow-Methods", "DELETE")
                            .allow("OPTIONS").build();
                } else {
                    return Response.notModified()
                            .entity(unit)
                            .header("Access-Control-Allow-Origin", "*")
                            .header("Access-Control-Allow-Methods", "DELETE")
                            .allow("OPTIONS").build();
                }
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(unit)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "DELETE")
                        .allow("OPTIONS").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage())
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "DELETE")
                    .allow("OPTIONS").build();

        }

    }
}
