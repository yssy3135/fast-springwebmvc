package com.fast.springwebmvc.controller.api;

import com.fast.springwebmvc.constant.ErrorCode;
import com.fast.springwebmvc.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {


    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }


    @DisplayName("[view][GET] 기본 페이지 요청")
    @Test
    void givenNothing_whenRequestingPlaces_thenReturnsListOfPlacesInStandardResponse() throws  Exception{

        mvc.perform(get("/api/places"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data[0].placeName").value("랄라배드민턴장"))
                .andExpect(jsonPath("$.data[0].address").value("서울시"))
                .andExpect(jsonPath("$.data[0].phoneNumber").value("010-1234-5678"))
                .andExpect(jsonPath("$.data[0].capacity").value(30))
                .andExpect(jsonPath("$.data[0].memo").value("신장개업"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("message").value(ErrorCode.OK.getMessage()));


    }

    @DisplayName("[view][GET] 단일 장소 조회 - 장소 있는 경우")
    @Test
    void givePlaceAndItsId_whenRequestingPlace_thenReturnsPlaceInStandardResponse() throws  Exception{

        int placeId = 1;

        mvc.perform(get("/api/places/"+ placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isMap())
                .andExpect(jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data.placeName").value("랄라배드민턴장"))
                .andExpect(jsonPath("$.data.address").value("서울시"))
                .andExpect(jsonPath("$.data.phoneNumber").value("010-1234-5678"))
                .andExpect(jsonPath("$.data.capacity").value(30))
                .andExpect(jsonPath("$.data.memo").value("신장개업"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("message").value(ErrorCode.OK.getMessage()));


    }

    @DisplayName("[view][GET] 단일 장소 조회 - 장소 없는 경우")
    @Test
    void givePlaceAndItsId_whenRequestingPlace_thenReturnsEmptyStandardResponse() throws  Exception{

        int placeId = 2;

        mvc.perform(get("/api/places/"+ placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isEmpty())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("message").value(ErrorCode.OK.getMessage()));


    }

}