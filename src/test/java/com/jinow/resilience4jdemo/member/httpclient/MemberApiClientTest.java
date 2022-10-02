package com.jinow.resilience4jdemo.member.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberApiClientTest {
    @Autowired
    private MemberApiClient memberApiClient;

    @Test
    public void memberApiCallTest() {
        memberApiClient.getMemberPersonal(540364L);
        log.warn("=======test 종료 =======");
    }
}