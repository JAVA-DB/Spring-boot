package com.example.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api/")
public class DeleteController {

    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable(value = "variable") String var){
        return var;
    }

    @DeleteMapping(value = "/request1")
    public String DeleteVariable1(@RequestParam(value = "email") String email){
        return email;
    }

}