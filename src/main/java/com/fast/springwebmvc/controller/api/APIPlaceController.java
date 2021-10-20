package com.fast.springwebmvc.controller.api;


import com.fast.springwebmvc.constant.PlaceType;
import com.fast.springwebmvc.dto.APIDataResponse;
import com.fast.springwebmvc.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIPlaceController {

    @GetMapping("places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {return APIDataResponse.of(List.of(PlaceDTO.of(
            PlaceType.COMMON,
             "랄라배드민턴장",
            "서울시",
            "010-1234-5678",
            30,
            "신장개업"
    )));
    }

    @PostMapping("/places")
    public Boolean createPlace() { return true;}

    @GetMapping("places/{placeId}")
    public APIDataResponse getPlace(@PathVariable Integer placeId) {
        if(placeId.equals(2)){
            return APIDataResponse.of(null);
        }

        return APIDataResponse.of((PlaceDTO.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시",
                "010-1234-5678",
                30,
                "신장개업"
        )));
    }

    @PutMapping("places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) {return true;}

    @DeleteMapping("places/{placeId}")
    public Boolean deletePlace(@PathVariable Integer placeId) {return true;}





}
