/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.apps.heroesofempires.basic;

/**
 *
 * @author krisztian
 */
public abstract class BussinessError<T> {
    protected byte category;
    protected String message, code, property;
    protected Exception exception;
    protected T data;

    public BussinessError() {
    }

    public BussinessError(String code, String message, T data, String property, Exception exception, byte category) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.property = property;
        this.exception = exception;
        this.category = category;
    }

    public byte getCategory() {
        return category;
    }

    public void setCategory(byte category) {
        this.category = category;
    }    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }    
    
}
