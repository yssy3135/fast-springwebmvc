package com.fast.springwebmvc.controller.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIAuthController {

    @GetMapping("siup-up")
    public String signUp(){
        return "done.";
    }

}
