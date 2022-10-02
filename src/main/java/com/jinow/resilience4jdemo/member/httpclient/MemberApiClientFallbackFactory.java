package com.jinow.resilience4jdemo.member.httpclient;

import com.jinow.resilience4jdemo.member.httpclient.response.MemberResponseV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberApiClientFallbackFactory implements FallbackFactory<MemberApiClient> {
    @Override
    public MemberApiClient create(Throwable cause) {
        return new MemberApiClient() {
            @Override
            public MemberResponseV1 getMemberPersonal(Long memberUid) {
                log.warn(cause.getMessage());
                return null;
            }
        };
    }
}
