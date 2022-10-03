package com.jinow.resilience4jdemo.member.controller;

import com.jinow.resilience4jdemo.member.httpclient.MemberApiClient;
import com.jinow.resilience4jdemo.member.httpclient.response.MemberResponseV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberApiClient memberApiClient;

    @GetMapping("/api/member/{memberUid}")
    public MemberResponseV1 testCall(@PathVariable Long memberUid) {
        return memberApiClient.getMemberPersonal(memberUid);
    }
}
