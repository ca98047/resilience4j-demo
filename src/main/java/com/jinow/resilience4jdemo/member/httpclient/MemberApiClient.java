package com.jinow.resilience4jdemo.member.httpclient;

import com.jinow.resilience4jdemo.member.httpclient.response.MemberResponseV1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "memberApiClient",
        url = "${internal.iapi.member-api}")
public interface MemberApiClient {

    @GetMapping(value = "/v1/{memberUid}")
    MemberResponseV1 getMemberPersonal(@PathVariable("memberUid") Long memberUid);

}
