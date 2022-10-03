package com.example.api.controller;

import com.example.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String getHello(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World!!!";
    }

    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        LOGGER.info("@PathVariabled을 통해 들어온 값 : {}.", variable);
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value = "/variable3/{variable}")
    public String getVariable3(@PathVariable(value = "variable") String var){
        return var;
    }

    @GetMapping(value = "request1")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "request2")
    public String getRequestParam2(@RequestParam(value = "name") String n, @RequestParam String email, @RequestParam String organization){
        return n + " " + email + " " + organization;
    }

    @GetMapping(value = "request3")
    public String getRequestParam3(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "request4")
    public String getRequestParam4(MemberDto memberDto){
        return memberDto.toString();
    }

    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request5")
    public String getRequestParan1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization
    ) {
        return name + " : " + email + " : " + organization;
    }
}

