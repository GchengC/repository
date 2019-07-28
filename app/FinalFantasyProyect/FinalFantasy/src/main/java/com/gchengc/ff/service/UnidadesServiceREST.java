package com.gchengc.ff.service;

import com.gchengc.ff.model.UnidadesModel;

import javax.persistence.EntityManager;

import javax.ejb.Stateless;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Stateless
@Path("units")
public class UnidadesServiceREST extends AbstractFacade<UnidadesModel> {

    private static EntityManager em;

    public UnidadesServiceREST() {
        super(UnidadesModel.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public String create(UnidadesModel entity) {
        System.out.println("Estoy en servicio");
        System.out.println("data: " + entity.getName());
        String result = super.create(entity);
        return result;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UnidadesModel find(@PathParam("id") long id) {
        return super.find(id);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public String edit(@PathParam("id") String id, UnidadesModel entity) {
        String result = super.edit(entity);
        return result;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<UnidadesModel> findAll() {
        return super.findAll();
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") long id) {
        String result = super.remove(super.find(id));
        return result;
    }
}
