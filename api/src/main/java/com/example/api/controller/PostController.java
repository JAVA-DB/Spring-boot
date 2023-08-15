package com.example.api.controller;

import com.example.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value="/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API!!!";
    }

    @PostMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    @PostMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @PostMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @PostMapping(value = "/variable3/{variable}")
    public String getVariable3(@PathVariable(value = "variable") String var){
        return var;
    }

    @PostMapping(value = "request1")
    public String getRequestParam1(@RequestBody String name, @RequestBody String email, @RequestBody String organization){
        return name + " " + email + " " + organization+"111111111111111111111111";
    }

    @PostMapping(value = "request2")
    public String getRequestParam2(@RequestBody(required = true) String n, @RequestBody String email, @RequestBody String organization){
        return n + " " + email + " " + organization;
    }

    @PostMapping(value = "request3")
    public String getRequestParam3(@RequestBody Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping(value = "request4")
    public String getRequestParam4(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
