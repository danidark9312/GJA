/**
 *
 */
package com.sf.util;

import java.util.ResourceBundle;

/**
 * @author Dmonsalve
 *
 */
public class Parametros {

    private static ResourceBundle properties = ResourceBundle.getBundle("com.sf.util.parametros");

    private Parametros() {
    }

    public static String[] getListadoAbecedarioContactos() {
    	return properties.getString("ABECEDARIO.CONTACTOS").split(",");
    }

        
    public static String getCorreoEnvioDocumentos() {
    	return properties.getString("CORREO.ENVIO.DOCUMENTOS");
    }
    
    public static String getPasswordCorreoEnvios() {
    	return properties.getString("PASSWORD.CORREO.ENVIOS");
    }
    
    public static int getMailPort() {
    	return Integer.parseInt(properties.getString("MAIL.PORT"));
    }
    
    public static String getMailHost() {
    	return properties.getString("MAIL.HOST");
    }
    
    public static Long getMaxSizeArchivo() {
    	return Long.parseLong(properties.getString("MAX.SIZE.ARCHIVO"));
    }
    
    public static int getMaxInSizeMemory() {
    	return Integer.parseInt(properties.getString("MAX.SIZE.IN.MEMORY"));
    }
    
    public static String getRutaCargaArchivos() {
    	return properties.getString("RUTA.CARGA.ARCHIVOS");
    }
    
    public static Integer getEstadoConstruccion() {
    	return new Integer(properties.getString("ESTADO.CONSTRUCCION"));
    }
    
    public static Integer getEstadoEvaluacion() {
    	return new Integer(properties.getString("ESTADO.EVALUACION"));
    }
    
    public static Integer getEstadoPlanDesarrollo() {
    	return new Integer(properties.getString("ESTADO.PLANDESARROLLO"));
    }
    
    public static String getEstadoActivo() {
    	return properties.getString("ESTADO.TIPOCASO.ACTIVO");
    }
    public static String getEstadoInactivo() {
    	return properties.getString("ESTADO.TIPOCASO.INACTIVO");
    }
    public static String getAnosCaducidad() {
    	return properties.getString("ANOS.CADUCIDAD");
    }
    public static String getMensajeErrorLogin() {
    	return properties.getString("LOGIN.MENSAJE.ERROR");
    }
}
