package com.farmatodo.notifications.service;

import com.farmatodo.commons.database.DataSourceDao;
import com.farmatodo.commons.exception.FarmatodoException;
import com.farmatodo.commons.factory.FactoryApp;
import com.farmatodo.commons.interfaces.ICustomBusinessDao;
import com.farmatodo.commons.log4j.FarmatodoLevel;
import com.farmatodo.notifications.constants.Constants;
import com.farmatodo.notifications.dao.NotificationMiscDao;
import com.farmatodo.notifications.to.NotificationRequestTo;
import com.farmatodo.notifications.to.NotificationResponseTo;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotificationMiscService {
    private static final Logger logger = Logger.getLogger(NotificationMiscService.class);

    private Gson gson;
    private DataSourceDao dataSourceDao;
    NotificationResponseTo notificationResponse;

    @OPTIONS
    @Path("/noti/misc/noti")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiIdQueryService(@FormParam("RequestJson") String requestJson,
                                       @Context HttpServletResponse servletResponse,
                                       @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiIdQueryService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationRequestTo requestTo = gson.fromJson(requestJson, NotificationRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationResponse = new NotificationResponseTo();
                notificationResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationRequestTo, NotificationResponseTo> factoryApp =
                        new FactoryApp<>(new NotificationResponseTo());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICustomBusinessDao<NotificationRequestTo, NotificationResponseTo> simpleDao = new NotificationMiscDao(dataSourceDao);
                notificationResponse = factoryApp.call(simpleDao::queryDao, requestTo);

                if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                    logger.log(FarmatodoLevel.INFO, new Object[]{requestTo.getTransactionId()
                            , System.getProperty("NODO")
                            , requestTo.getSource()
                            , metodo
                            , requestTo.getSecurity().getUser()
                            , requestTo.getTransactionType()
                            , requestTo.getApplication().getId()
                            , requestTo.getCountry()
                            , ip
                            , host
                            , String.valueOf(System.currentTimeMillis() - tiempo)});
                }
            }
        }
        return notificationResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/misc/head")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiIdHeadService(@FormParam("RequestJson") String requestJson,
                                      @Context HttpServletResponse servletResponse,
                                      @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiIdHeadService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationRequestTo requestTo = gson.fromJson(requestJson, NotificationRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationResponse = new NotificationResponseTo();
                notificationResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationRequestTo, NotificationResponseTo> factoryApp =
                        new FactoryApp<>(new NotificationResponseTo());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICustomBusinessDao<NotificationRequestTo, NotificationResponseTo> simpleDao = new NotificationMiscDao(dataSourceDao);
                notificationResponse = factoryApp.call(simpleDao::getDao, requestTo);

                if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                    logger.log(FarmatodoLevel.INFO, new Object[]{requestTo.getTransactionId()
                            , System.getProperty("NODO")
                            , requestTo.getSource()
                            , metodo
                            , requestTo.getSecurity().getUser()
                            , requestTo.getTransactionType()
                            , requestTo.getApplication().getId()
                            , requestTo.getCountry()
                            , ip
                            , host
                            , String.valueOf(System.currentTimeMillis() - tiempo)});
                }
            }
        }
        return notificationResponse.getRespuestaJson();
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public DataSourceDao getDataSourceDao() {
        return dataSourceDao;
    }

    public void setDataSourceDao(DataSourceDao dataSourceDao) {
        this.dataSourceDao = dataSourceDao;
    }
}
