package com.facturaExpress.InvoiceService.Commons.Exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
