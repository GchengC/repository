package com.farmatodo.notifications.dao;

import com.farmatodo.commons.exception.AdvertenciaFuncionalException;
import com.farmatodo.commons.exception.FarmatodoException;
import com.farmatodo.commons.exception.ManejadorExcepciones;
import com.farmatodo.commons.interfaces.ICommonBusinessDao;
import com.farmatodo.commons.interfaces.IDao;
import com.farmatodo.commons.log4j.FarmatodoLevel;
import com.farmatodo.commons.to.ResponseTo;
import com.farmatodo.commons.util.RequestResponsePkgMain;
import com.farmatodo.notifications.constants.Constants;
import com.farmatodo.notifications.to.*;
import com.google.gson.Gson;
import oracle.jdbc.internal.OracleTypes;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;

import static com.farmatodo.notifications.constants.Constants.*;

public class NotificationSchedDao implements ICommonBusinessDao<NotificationSchedRequestTo, NotificationSchedResponse> {
    private static final Logger logger = Logger.getLogger(NotificationSchedDao.class);
    private IDao dao;

    public NotificationSchedDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public NotificationSchedResponse queryDao(NotificationSchedRequestTo notificationSchedRequestTo) throws FarmatodoException {
        final String transaccionId = notificationSchedRequestTo.getTransactionId();
        final String metodo = getClass().getCanonicalName() + ".queryDao";
        final String origen = notificationSchedRequestTo.getSource();
        final String nodo = System.getProperty("NODO");
        final String tipoTransaccion = FarmatodoException.TIPO_TRANSACCION_DB;
        final String aplicacion = Constants.NOMBRE_APLICACION;
        final String usuario = notificationSchedRequestTo.getSecurity().getUser();
        final String country = notificationSchedRequestTo.getCountry();
        long tiempo = System.currentTimeMillis();
        NotificationSchedResponse responseTo = new NotificationSchedResponse();
        try (
                Connection conn = dao.getConnection();
                CallableStatement stmt = conn.prepareCall(com.farmatodo.commons.constants.Constants.PRC_MAIN)
        ) {
            Gson gson = new Gson();

            //Hace la instancia para mapear el requestTo en el Parameter del PKG_MAIN
            //---------------------------------------------------------
            NotificationParameter notificationParameter = new NotificationParameter();

            RequestResponsePkgMain requestResponsePkgMain = new
                    RequestResponsePkgMain<NotificationRequestTo, ResponseTo>(responseTo);
            // Seteo de los parametros del request
            //---------------------------------------------------------
            notificationParameter.setParameters(requestResponsePkgMain.getJsonPublicParamRequestSelectAllGet(
                    MUDULE_NAME, PRC_NOTI_SCHE_GET, notificationSchedRequestTo));

            // Serializa a Json los parametros de entrada del
            //---------------------------------------------------------
            String jsonParametersRequest = gson.toJson(notificationParameter);
            // Pasando los parametros al Stored Procedure
            //---------------------------------------------------------
            stmt.setString(1, jsonParametersRequest);
            stmt.registerOutParameter(2, OracleTypes.CLOB);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.registerOutParameter(4, OracleTypes.CLOB);
            // Ejecuta procedure
            //---------------------------------------------------------
            stmt.execute();
            // Toma resultado
            //---------------------------------------------------------
            responseTo = (NotificationSchedResponse) requestResponsePkgMain.getSmsResponse(stmt.getString(4), notificationSchedRequestTo);

            // Escribe en log
            //---------------------------------------------------------
            if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                logger.log(FarmatodoLevel.INFO, new Object[]{transaccionId
                        , nodo
                        , origen
                        , metodo
                        , usuario
                        , tipoTransaccion
                        , aplicacion
                        , country
                        , Constants.DATASOURCE_BD_BDOS
                        , responseTo.getCod()
                        , responseTo.getMessage()
                        , String.valueOf(System.currentTimeMillis() - tiempo)});
            }

            // Evalua resultado
            //---------------------------------------------------------
            if (!responseTo.getCod().equals(Constants.BD_CODIGO_EXITO)) {
                throw new AdvertenciaFuncionalException(notificationSchedRequestTo, responseTo)
                        .code(responseTo.getCod())
                        .plataform(Constants.DATASOURCE_BD_BDOS)
                        .transactionType(tipoTransaccion)
                        .application(aplicacion)
                        .method(metodo)
                        .logger(logger);
            } else {
                NotificationSchedList scheduleData = gson.fromJson(stmt.getString(2), NotificationSchedList.class);
                responseTo.setScheduleData(scheduleData.getScheduleData());
            }
        } catch (Exception ex) {
            ManejadorExcepciones.manejarYLanzar(
                    new FarmatodoException()
                            .logger(logger)
                            .method(metodo)
                            .parameter("")
                            .throwable(ex));
        }
        return responseTo;
    }

    @Override
    public NotificationSchedResponse saveDao(NotificationSchedRequestTo notificationSchedRequestTo) throws FarmatodoException {
        final String transaccionId = notificationSchedRequestTo.getTransactionId();
        final String metodo = getClass().getCanonicalName() + ".saveDao";
        final String origen = notificationSchedRequestTo.getSource();
        final String nodo = System.getProperty("NODO");
        final String tipoTransaccion = FarmatodoException.TIPO_TRANSACCION_DB;
        final String aplicacion = Constants.NOMBRE_APLICACION;
        final String usuario = notificationSchedRequestTo.getSecurity().getUser();
        final String country = notificationSchedRequestTo.getCountry();
        long tiempo = System.currentTimeMillis();
        NotificationSchedResponse responseTo = new NotificationSchedResponse();
        try (
                Connection conn = dao.getConnection();
                CallableStatement stmt = conn.prepareCall(com.farmatodo.commons.constants.Constants.PRC_MAIN)
        ) {
            Gson gson = new Gson();

            //Hace la instancia para mapear el requestTo en el Parameter del PKG_MAIN
            //---------------------------------------------------------
            NotificationParameter notificationParameter = new NotificationParameter();

            RequestResponsePkgMain requestResponsePkgMain = new
                    RequestResponsePkgMain<NotificationRequestTo, ResponseTo>(responseTo);
            // Seteo de los parametros del request
            //---------------------------------------------------------
            notificationParameter.setParameters(requestResponsePkgMain.getPublicParamRequestSet(
                    MUDULE_NAME, PRC_SET_NOTI_SCHE, notificationSchedRequestTo));
            notificationParameter.setScheduleData(notificationSchedRequestTo.getScheduleData());

            // Serializa a Json los parametros de entrada del
            //---------------------------------------------------------
            String jsonParametersRequest = gson.toJson(notificationParameter);
            // Pasando los parametros al Stored Procedure
            //---------------------------------------------------------
            stmt.setString(1, jsonParametersRequest);
            stmt.registerOutParameter(2, OracleTypes.CLOB);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.registerOutParameter(4, OracleTypes.CLOB);
            // Ejecuta procedure
            //---------------------------------------------------------
            stmt.execute();
            // Toma resultado
            //---------------------------------------------------------
            responseTo = (NotificationSchedResponse) requestResponsePkgMain.getSmsResponse(stmt.getString(4), notificationSchedRequestTo);

            // Escribe en log
            //---------------------------------------------------------
            if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                logger.log(FarmatodoLevel.INFO, new Object[]{transaccionId
                        , nodo
                        , origen
                        , metodo
                        , usuario
                        , tipoTransaccion
                        , aplicacion
                        , country
                        , Constants.DATASOURCE_BD_BDOS
                        , responseTo.getCod()
                        , responseTo.getMessage()
                        , String.valueOf(System.currentTimeMillis() - tiempo)});
            }

            // Evalua resultado
            //---------------------------------------------------------
            if (!responseTo.getCod().equals(Constants.BD_CODIGO_EXITO)) {
                throw new AdvertenciaFuncionalException(notificationSchedRequestTo, responseTo)
                        .code(responseTo.getCod())
                        .plataform(Constants.DATASOURCE_BD_BDOS)
                        .transactionType(tipoTransaccion)
                        .application(aplicacion)
                        .method(metodo)
                        .logger(logger);
            }
        } catch (Exception ex) {
            ManejadorExcepciones.manejarYLanzar(
                    new FarmatodoException()
                            .logger(logger)
                            .method(metodo)
                            .parameter("")
                            .throwable(ex));
        }
        return responseTo;
    }

    @Override
    public NotificationSchedResponse deleteDao(NotificationSchedRequestTo notificationSchedRequestTo) throws FarmatodoException {
        final String transaccionId = notificationSchedRequestTo.getTransactionId();
        final String metodo = getClass().getCanonicalName() + ".saveDao";
        final String origen = notificationSchedRequestTo.getSource();
        final String nodo = System.getProperty("NODO");
        final String tipoTransaccion = FarmatodoException.TIPO_TRANSACCION_DB;
        final String aplicacion = Constants.NOMBRE_APLICACION;
        final String usuario = notificationSchedRequestTo.getSecurity().getUser();
        final String country = notificationSchedRequestTo.getCountry();
        long tiempo = System.currentTimeMillis();
        NotificationSchedResponse responseTo = new NotificationSchedResponse();
        try (
                Connection conn = dao.getConnection();
                CallableStatement stmt = conn.prepareCall(com.farmatodo.commons.constants.Constants.PRC_MAIN)
        ) {
            Gson gson = new Gson();

            //Hace la instancia para mapear el requestTo en el Parameter del PKG_MAIN
            //---------------------------------------------------------
            NotificationParameter notificationParameter = new NotificationParameter();

            RequestResponsePkgMain requestResponsePkgMain = new
                    RequestResponsePkgMain<NotificationRequestTo, ResponseTo>(responseTo);
            // Seteo de los parametros del request
            //---------------------------------------------------------
            notificationParameter.setParameters(requestResponsePkgMain.getPublicParamRequestSet(
                    MUDULE_NAME, PRC_DEL_NOTI_SCHE, notificationSchedRequestTo));
            notificationParameter.setScheduleData(notificationSchedRequestTo.getScheduleData());

            // Serializa a Json los parametros de entrada del
            //---------------------------------------------------------
            String jsonParametersRequest = gson.toJson(notificationParameter);
            // Pasando los parametros al Stored Procedure
            //---------------------------------------------------------
            stmt.setString(1, jsonParametersRequest);
            stmt.registerOutParameter(2, OracleTypes.CLOB);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.registerOutParameter(4, OracleTypes.CLOB);
            // Ejecuta procedure
            //---------------------------------------------------------
            stmt.execute();
            // Toma resultado
            //---------------------------------------------------------
            responseTo = (NotificationSchedResponse) requestResponsePkgMain.getSmsResponse(stmt.getString(4), notificationSchedRequestTo);

            // Escribe en log
            //---------------------------------------------------------
            if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                logger.log(FarmatodoLevel.INFO, new Object[]{transaccionId
                        , nodo
                        , origen
                        , metodo
                        , usuario
                        , tipoTransaccion
                        , aplicacion
                        , country
                        , Constants.DATASOURCE_BD_BDOS
                        , responseTo.getCod()
                        , responseTo.getMessage()
                        , String.valueOf(System.currentTimeMillis() - tiempo)});
            }

            // Evalua resultado
            //---------------------------------------------------------
            if (!responseTo.getCod().equals(Constants.BD_CODIGO_EXITO)) {
                throw new AdvertenciaFuncionalException(notificationSchedRequestTo, responseTo)
                        .code(responseTo.getCod())
                        .plataform(Constants.DATASOURCE_BD_BDOS)
                        .transactionType(tipoTransaccion)
                        .application(aplicacion)
                        .method(metodo)
                        .logger(logger);
            }
        } catch (Exception ex) {
            ManejadorExcepciones.manejarYLanzar(
                    new FarmatodoException()
                            .logger(logger)
                            .method(metodo)
                            .parameter("")
                            .throwable(ex));
        }
        return responseTo;
    }

    @Override
    public NotificationSchedResponse mergeDao(NotificationSchedRequestTo notificationSchedRequestTo) throws FarmatodoException {
        return null;
    }

    @Override
    public NotificationSchedResponse updateDao(NotificationSchedRequestTo notificationSchedRequestTo) throws FarmatodoException {
        final String transaccionId = notificationSchedRequestTo.getTransactionId();
        final String metodo = getClass().getCanonicalName() + ".saveDao";
        final String origen = notificationSchedRequestTo.getSource();
        final String nodo = System.getProperty("NODO");
        final String tipoTransaccion = FarmatodoException.TIPO_TRANSACCION_DB;
        final String aplicacion = Constants.NOMBRE_APLICACION;
        final String usuario = notificationSchedRequestTo.getSecurity().getUser();
        final String country = notificationSchedRequestTo.getCountry();
        long tiempo = System.currentTimeMillis();
        NotificationSchedResponse responseTo = new NotificationSchedResponse();
        try (
                Connection conn = dao.getConnection();
                CallableStatement stmt = conn.prepareCall(com.farmatodo.commons.constants.Constants.PRC_MAIN)
        ) {
            Gson gson = new Gson();

            //Hace la instancia para mapear el requestTo en el Parameter del PKG_MAIN
            //---------------------------------------------------------
            NotificationParameter notificationParameter = new NotificationParameter();

            RequestResponsePkgMain requestResponsePkgMain = new
                    RequestResponsePkgMain<NotificationRequestTo, ResponseTo>(responseTo);
            // Seteo de los parametros del request
            //---------------------------------------------------------
            notificationParameter.setParameters(requestResponsePkgMain.getPublicParamRequestSet(
                    MUDULE_NAME, PRC_UPD_NOTI_SCHE, notificationSchedRequestTo));
            notificationParameter.setScheduleData(notificationSchedRequestTo.getScheduleData());

            // Serializa a Json los parametros de entrada del
            //---------------------------------------------------------
            String jsonParametersRequest = gson.toJson(notificationParameter);
            // Pasando los parametros al Stored Procedure
            //---------------------------------------------------------
            stmt.setString(1, jsonParametersRequest);
            stmt.registerOutParameter(2, OracleTypes.CLOB);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.registerOutParameter(4, OracleTypes.CLOB);
            // Ejecuta procedure
            //---------------------------------------------------------
            stmt.execute();
            // Toma resultado
            //---------------------------------------------------------
            responseTo = (NotificationSchedResponse) requestResponsePkgMain.getSmsResponse(stmt.getString(4), notificationSchedRequestTo);

            // Escribe en log
            //---------------------------------------------------------
            if (logger.isEnabledFor(FarmatodoLevel.INFO)) {
                logger.log(FarmatodoLevel.INFO, new Object[]{transaccionId
                        , nodo
                        , origen
                        , metodo
                        , usuario
                        , tipoTransaccion
                        , aplicacion
                        , country
                        , Constants.DATASOURCE_BD_BDOS
                        , responseTo.getCod()
                        , responseTo.getMessage()
                        , String.valueOf(System.currentTimeMillis() - tiempo)});
            }

            // Evalua resultado
            //---------------------------------------------------------
            if (!responseTo.getCod().equals(Constants.BD_CODIGO_EXITO)) {
                throw new AdvertenciaFuncionalException(notificationSchedRequestTo, responseTo)
                        .code(responseTo.getCod())
                        .plataform(Constants.DATASOURCE_BD_BDOS)
                        .transactionType(tipoTransaccion)
                        .application(aplicacion)
                        .method(metodo)
                        .logger(logger);
            }
        } catch (Exception ex) {
            ManejadorExcepciones.manejarYLanzar(
                    new FarmatodoException()
                            .logger(logger)
                            .method(metodo)
                            .parameter("")
                            .throwable(ex));
        }
        return responseTo;
    }
}
