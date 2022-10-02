package com.jinow.resilience4jdemo.member.httpclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberApiClientTest {
    @Autowired
    private MemberApiClient memberApiClient;

    @Test
    public void memberApiCallTest() {
        memberApiClient.getMemberPersonal(540364L);
    }
}