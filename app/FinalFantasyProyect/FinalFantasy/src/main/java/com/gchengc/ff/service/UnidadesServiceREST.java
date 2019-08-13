package com.gchengc.ff.service;

import com.gchengc.ff.model.UnidadesModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import javax.ejb.Stateless;

import javax.transaction.UserTransaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;


@Stateless
@Path("units")
public class UnidadesServiceREST extends AbstractFacade<UnidadesModel> {

    private static EntityManager em;
    private Response.ResponseBuilder rp = null;
    private UnidadesModel unit;

    @Resource
    private UserTransaction tx;

    public UnidadesServiceREST() {
        super(UnidadesModel.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String entity) {
        System.out.println("Estoy en Rest" + entity);
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<UnidadesModel>() {
            }.getType();
            UnidadesModel entityList = gson.fromJson(entity, listType);
            if (!(boolean) super.create(entityList))
                return Response.status(Response.Status.NOT_FOUND)
                        /*.header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .header("Access-Control-Max-Age", "1209600")*/
                        .entity(entityList)
                        .build();


            return Response.status(Response.Status.CREATED)
                    /*   .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                       .header("Access-Control-Allow-Credentials", "true")
                       .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                       .header("Access-Control-Max-Age", "1209600")*/
                    .build();

        } catch (Exception e) {
            return Response.serverError()
                    /* .header("Access-Control-Allow-Origin", "*")
                     .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                     .header("Access-Control-Allow-Credentials", "true")
                     .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                     .header("Access-Control-Max-Age", "1209600")*/
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") long id, @HeaderParam("authorization") String token) {
        try {
            this.unit = new UnidadesModel();
            this.unit = super.find(id);
            if (unit != null) {
                return Response.ok()
                        /* .entity(unit)
                         .header("Access-Control-Allow-Origin", "*")
                         .header("Access-Control-Allow-Methods", "GET")
                         .allow("OPTIONS")*/
                        .build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        /*.header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .allow("OPTIONS")*/
                        .build();
            }
        } catch (Exception e) {
            return Response.serverError()
                    .entity(e.getMessage())
                    /* .header("Access-Control-Allow-Origin", "*")
                     .header("Access-Control-Allow-Methods", "GET")
                     .allow("OPTIONS")*/
                    .build();
        }
    }


    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        try {
            Object ob = super.findAll();
            if (ob != null) {
                return Response.ok().entity(new Gson().toJson(ob))
                        /*  .header("Access-Control-Allow-Origin", "*")
                          .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                          .header("Access-Control-Allow-Credentials", "true")
                          .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                          .header("Access-Control-Max-Age", "1209600")
                          .allow("OPTIONS")*/
                        .build();
            } else {
                return Response.noContent()
                        /*   .header("Access-Control-Allow-Origin", "*")
                           .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                           .header("Access-Control-Allow-Credentials", "true")
                           .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                           .header("Access-Control-Max-Age", "1209600")
                           .allow("OPTIONS")*/
                        .build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage())
                    /*     .header("Access-Control-Allow-Origin", "*")
                         .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                         .header("Access-Control-Allow-Credentials", "true")
                         .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                         .header("Access-Control-Max-Age", "1209600")
                         .allow("OPTIONS")*/
                    .build();
        }

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, UnidadesModel entity) {
        try {

            if ((boolean) super.edit(entity))
                return Response.notModified().entity(entity).build();


            return Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        try {

            this.unit = new UnidadesModel();
            this.unit = super.find(id);

            if (unit != null)
                if (!(boolean) super.remove(unit))
                    return Response.notModified().entity(unit).build();
                else
                    return Response.ok().build();

            return Response.status(Response.Status.NOT_FOUND).entity(unit).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

}
