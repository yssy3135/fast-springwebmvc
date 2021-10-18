package com.fast.springwebmvc.controller.api;

import com.fast.springwebmvc.constant.ErrorCode;
import com.fast.springwebmvc.dto.APIErrorResponse;
import com.fast.springwebmvc.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("events")
    public List<String> getEvents() throws Exception {
        throw new HttpRequestMethodNotSupportedException("스프링 에러 테스트");
//        return List.of("event1","event2");
    }

    @PostMapping("/events")
    public Boolean createEvent() {
        throw new GeneralException("장군님");
//        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId){
        throw new RuntimeException("런타임 에러");

//        return "event " + eventId;
    }

    @PutMapping("/events/{eventId}")
    public Boolean modifyevent(@PathVariable Integer eventId){return true;}

    @DeleteMapping("/events/{eventId}")
    public Boolean removeEvent(@PathVariable Integer eventId){return true;}

}
