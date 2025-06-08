package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUtil<T> implements Serializable {

    private static Integer BAD_REQUEST = 400;
    private static Integer OK = 200;

    private static String BAD_REQUEST_NAME = "Bad Request";
    private static String OK_NAME = "Success";

    private Integer status;
    private String code;
    private String message;
    private Long total;
    private T data;

    public ResponseUtil() {}

    public ResponseUtil(int status, String message){
        this.status = status;
        this.message = message;
    }

    public ResponseUtil(int status, String message, String declineCode){
        this.status = status;
        this.message = message;
        this.code = declineCode;
    }

    public ResponseUtil(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseUtil(int status, String message, T data, Long total){
        this.status = status;
        this.message = message;
        this.total = total;
        this.data = data;
    }



    public static <T> ResponseUtil<T> success() {
        return new ResponseUtil<>(OK, OK_NAME);
    }

    public static <T> ResponseUtil<T> success(String msg) {
        return new ResponseUtil<>(OK, msg);
    }

    public static <T> ResponseUtil<T> fail() {
        return new ResponseUtil<>(BAD_REQUEST, BAD_REQUEST_NAME);
    }

    public static <T> ResponseUtil<T> fail(String message) {
        return new ResponseUtil<>(BAD_REQUEST, message);
    }

    public static <T> ResponseUtil<T> fail(int status, String message) {
        return new ResponseUtil<>(status, message);
    }

    public static <T> ResponseUtil<T> fail(int status, String message, String code) {
        return new ResponseUtil<>(status, message, code);
    }

    public static <T> ResponseUtil<T> data(T data) {
        return new ResponseUtil<>(OK, OK_NAME, data);
    }

    public static <T> ResponseUtil<T> data(T data, int status) {
        return new ResponseUtil<>(status, status == 200 ? OK_NAME : BAD_REQUEST_NAME, data);
    }

    public static <T> ResponseUtil<T> data(T data, Long total) {
        return new ResponseUtil<>(OK, OK_NAME, data, total);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
