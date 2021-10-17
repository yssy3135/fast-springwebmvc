package com.fast.springwebmvc.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse extends com.fast.springwebmvc.dto.APIErrorResponse {

    private final Object data;

    public APIDataResponse(boolean success,Integer errorCode,String message,Object data) {
        super(success,errorCode,message);
        this.data = data;
    }
    public APIDataResponse of(boolean success,Integer errorCode,String message,Object data) {
        return new APIDataResponse(success, errorCode,message, data);
    }



}
