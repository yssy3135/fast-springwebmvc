package com.fast.springwebmvc.exception;

import com.fast.springwebmvc.constant.ErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{
    private final ErrorCode errorCode;


    public GeneralException() {
        super();
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message) {
        super(message);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message, Throwable cause) {
        super(message,cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(Throwable cause) {
        super(cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
        super(message,cause,enableSuppression,writableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, Throwable cause, boolean enableSuppression,boolean wriableStackTrace){
        super(errorCode.getMessage(),cause,enableSuppression,wriableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }




}
