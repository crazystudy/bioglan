package com.masterlee.model;

public class ResponseResult<T> {
    private  String errorCode =null;
    private  String errorMessage =null;
    private  T responseData;
    private  boolean responseStatus = true;
    private  long count ;
    public ResponseResult(String errorCode, String errorMessage, boolean responseStatus){
        this.errorCode = errorCode;
        this.errorMessage =errorMessage;
        this.responseStatus =responseStatus;
    }
    public ResponseResult(T responseData, boolean responseStatus){
        this.responseData = responseData;
        this.responseStatus =responseStatus;
    }
    public ResponseResult(T responseData, long count, boolean responseStatus){
        this.responseData = responseData;
        this.responseStatus =responseStatus;
        this.count = count;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseStatus(Boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Boolean getResponseStatus() {
        return responseStatus;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
