package com.farmatodo.notifications.service;

import com.farmatodo.commons.database.DataSourceDao;
import com.farmatodo.commons.exception.FarmatodoException;
import com.farmatodo.commons.factory.FactoryApp;
import com.farmatodo.commons.interfaces.ICommonBusinessDao;
import com.farmatodo.commons.log4j.FarmatodoLevel;
import com.farmatodo.notifications.constants.Constants;
import com.farmatodo.notifications.dao.NotificationHeadDao;
import com.farmatodo.notifications.to.NotificationHeadRequestTo;
import com.farmatodo.notifications.to.NotificationHeadResponse;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotificationHeadService {
    private static final Logger logger = Logger.getLogger(NotificationHeadService.class);

    private Gson gson;
    private DataSourceDao dataSourceDao;
    NotificationHeadResponse notificationHeadResponse;

    @OPTIONS
    @Path("/noti/head/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiHeadQueryService(@FormParam("RequestJson") String requestJson,
                                         @Context HttpServletResponse servletResponse,
                                         @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiHeadQueryService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationHeadRequestTo requestTo = gson.fromJson(requestJson, NotificationHeadRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationHeadResponse = new NotificationHeadResponse();
                notificationHeadResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationHeadRequestTo, NotificationHeadResponse> factoryApp =
                        new FactoryApp<>(new NotificationHeadResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationHeadRequestTo, NotificationHeadResponse> simpleDao = new NotificationHeadDao(dataSourceDao);
                notificationHeadResponse = factoryApp.call(simpleDao::queryDao, requestTo);

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
        return notificationHeadResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/head/set")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiHeadSetService(@FormParam("RequestJson") String requestJson,
                                       @Context HttpServletResponse servletResponse,
                                       @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiHeadSetService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationHeadRequestTo requestTo = gson.fromJson(requestJson, NotificationHeadRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationHeadResponse = new NotificationHeadResponse();
                notificationHeadResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationHeadRequestTo, NotificationHeadResponse> factoryApp =
                        new FactoryApp<>(new NotificationHeadResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationHeadRequestTo, NotificationHeadResponse> simpleDao = new NotificationHeadDao(dataSourceDao);
                notificationHeadResponse = factoryApp.call(simpleDao::saveDao, requestTo);

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
        return notificationHeadResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/head/upd")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiHeadUpdService(@FormParam("RequestJson") String requestJson,
                                       @Context HttpServletResponse servletResponse,
                                       @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiHeadUpdService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationHeadRequestTo requestTo = gson.fromJson(requestJson, NotificationHeadRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationHeadResponse = new NotificationHeadResponse();
                notificationHeadResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationHeadRequestTo, NotificationHeadResponse> factoryApp =
                        new FactoryApp<>(new NotificationHeadResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationHeadRequestTo, NotificationHeadResponse> simpleDao = new NotificationHeadDao(dataSourceDao);
                notificationHeadResponse = factoryApp.call(simpleDao::updateDao, requestTo);

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
        return notificationHeadResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/head/del")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiHeadDelService(@FormParam("RequestJson") String requestJson,
                                       @Context HttpServletResponse servletResponse,
                                       @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiHeadDelService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationHeadRequestTo requestTo = gson.fromJson(requestJson, NotificationHeadRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationHeadResponse = new NotificationHeadResponse();
                notificationHeadResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationHeadRequestTo, NotificationHeadResponse> factoryApp =
                        new FactoryApp<>(new NotificationHeadResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationHeadRequestTo, NotificationHeadResponse> simpleDao = new NotificationHeadDao(dataSourceDao);
                notificationHeadResponse = factoryApp.call(simpleDao::deleteDao, requestTo);

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
        return notificationHeadResponse.getRespuestaJson();
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
