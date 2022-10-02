package com.jinow.resilience4jdemo.member.httpclient.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberResponseV1 {
    private Long memberUid = null;

    private String hashId = "";

    private String memberId = "";

    private String name = "";

    private String nameEnc = "";

    private String nickname = "";

    private Integer auth = 0;

    private String email = "";

    private Integer sex = 0;

    private String mobileNumber = "";

    private String phoneEnc = "";

    private String birthDate = "";

    private String birthDateEnc = "";

    private Integer level = 0;

    private String grade = "";

    private String ageSeg = "";
}
