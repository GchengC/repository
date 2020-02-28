package com.farmatodo.notifications.service;

import com.farmatodo.commons.database.DataSourceDao;
import com.farmatodo.commons.exception.FarmatodoException;
import com.farmatodo.commons.factory.FactoryApp;
import com.farmatodo.commons.interfaces.ICommonBusinessDao;
import com.farmatodo.commons.log4j.FarmatodoLevel;
import com.farmatodo.notifications.constants.Constants;
import com.farmatodo.notifications.dao.NotificationSchedDao;
import com.farmatodo.notifications.to.NotificationSchedRequestTo;
import com.farmatodo.notifications.to.NotificationSchedResponse;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotificationSchedService {
    private static final Logger logger = Logger.getLogger(NotificationHeadService.class);

    private Gson gson;
    private DataSourceDao dataSourceDao;
    NotificationSchedResponse notificationSchedResponse;

    @OPTIONS
    @Path("/noti/sched/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiSchedQueryService(@FormParam("RequestJson") String requestJson,
                                          @Context HttpServletResponse servletResponse,
                                          @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiSchedQueryService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationSchedRequestTo requestTo = gson.fromJson(requestJson, NotificationSchedRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationSchedResponse = new NotificationSchedResponse();
                notificationSchedResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationSchedRequestTo, NotificationSchedResponse> factoryApp =
                        new FactoryApp<>(new NotificationSchedResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationSchedRequestTo, NotificationSchedResponse> simpleDao = new NotificationSchedDao(dataSourceDao);
                notificationSchedResponse = factoryApp.call(simpleDao::queryDao, requestTo);

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
        return notificationSchedResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/sched/set")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiSchedSetService(@FormParam("RequestJson") String requestJson,
                                        @Context HttpServletResponse servletResponse,
                                        @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiSchedSetService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationSchedRequestTo requestTo = gson.fromJson(requestJson, NotificationSchedRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationSchedResponse = new NotificationSchedResponse();
                notificationSchedResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationSchedRequestTo, NotificationSchedResponse> factoryApp =
                        new FactoryApp<>(new NotificationSchedResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationSchedRequestTo, NotificationSchedResponse> simpleDao = new NotificationSchedDao(dataSourceDao);
                notificationSchedResponse = factoryApp.call(simpleDao::saveDao, requestTo);

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
        return notificationSchedResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/sched/upd")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiSchedUpdService(@FormParam("RequestJson") String requestJson,
                                        @Context HttpServletResponse servletResponse,
                                        @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiSchedUpdService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationSchedRequestTo requestTo = gson.fromJson(requestJson, NotificationSchedRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationSchedResponse = new NotificationSchedResponse();
                notificationSchedResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationSchedRequestTo, NotificationSchedResponse> factoryApp =
                        new FactoryApp<>(new NotificationSchedResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationSchedRequestTo, NotificationSchedResponse> simpleDao = new NotificationSchedDao(dataSourceDao);
                notificationSchedResponse = factoryApp.call(simpleDao::updateDao, requestTo);

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
        return notificationSchedResponse.getRespuestaJson();
    }

    @OPTIONS
    @Path("/noti/sched/del")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response notiSchedDelService(@FormParam("RequestJson") String requestJson,
                                        @Context HttpServletResponse servletResponse,
                                        @Context HttpServletRequest servletRequest) throws FarmatodoException {

        final String metodo = getClass().getCanonicalName() + ".notiSchedDelService";
        String header = servletRequest.getHeader("Access-Control-Request-Method");
        long tiempo = System.currentTimeMillis();
        String ip = servletRequest.getRemoteAddr();
        String host = servletRequest.getRemoteHost();
        if (header == null) {
            NotificationSchedRequestTo requestTo = gson.fromJson(requestJson, NotificationSchedRequestTo.class);
            if (requestTo.getCountry() == null || requestTo.getCountry().equals("")) {
                notificationSchedResponse = new NotificationSchedResponse();
                notificationSchedResponse.setMessage(Constants.MSJ_ERR_COUNTRY);

            } else {
                // Instanciando clase FactoryApp
                //---------------------------------------------------------
                FactoryApp<NotificationSchedRequestTo, NotificationSchedResponse> factoryApp =
                        new FactoryApp<>(new NotificationSchedResponse());

                // Ejecutando accion para traer facturas no resueltas
                //---------------------------------------------------------
                ICommonBusinessDao<NotificationSchedRequestTo, NotificationSchedResponse> simpleDao = new NotificationSchedDao(dataSourceDao);
                notificationSchedResponse = factoryApp.call(simpleDao::deleteDao, requestTo);

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
        return notificationSchedResponse.getRespuestaJson();
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
