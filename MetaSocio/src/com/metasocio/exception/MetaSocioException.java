package com.metasocio.exception;
/**
 * @author Pooja Khandelwal
 * @created date 29/10/2015
 * @name VehicleException
 * @description It will handle all the exceptions
 */
public class MetaSocioException extends Exception {
	public MetaSocioException(String message) {
		super(message);
	}
	public MetaSocioException(String message, Throwable cause) {
		super(message, cause);
	}
}
