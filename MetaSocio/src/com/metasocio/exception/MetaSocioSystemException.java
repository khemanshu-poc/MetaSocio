package com.metasocio.exception;
/**
 * @author Pooja Khandelwal
 * @created date 27/10/2015
 * @name VehicleSystemException
 * @description It will handle all the system exceptions
 */
public class MetaSocioSystemException extends MetaSocioException {
	public MetaSocioSystemException(String message) {
		super(message);
	}
	public MetaSocioSystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
