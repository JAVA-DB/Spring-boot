package com.example.api.controller;

import com.example.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/member")
    public String postMemberDto1(@RequestBody Map<String, String> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    @PutMapping(value = "/member2")
    public MemberDto postMemberDto3(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto4(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
