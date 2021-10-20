package com.fast.springwebmvc.dto;


import com.fast.springwebmvc.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse<T> extends APIErrorResponse {

    private final T data;

    public APIDataResponse(Object data) {
        super(true, ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        this.data = (T) data;
    }
    public static <T> APIDataResponse<T>  of(T data) {
        return new APIDataResponse(data);
    }



}
