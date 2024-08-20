package com.ll.spring_boot_exam_2.controller;

import com.ll.spring_boot_exam_2.RsData;
import com.ll.spring_boot_exam_2.domain.Member;
import com.ll.spring_boot_exam_2.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {

    private final MemberService memberService;


    //이렇게 요청이 들어올 때의 바디를 따로 빼서 만들어도 가능하다~
    @AllArgsConstructor
    @Getter
    public static class MemberJoinReqBody{
        @NotBlank(message = "아이디를 입력해주세여") //val으로 걸어두고 사용할 때도 꼭 valid를 사용해야한다.
        private String username;
        @NotBlank
        private String password;
        @NotBlank
        private String nickname;
    }

    //CRUD에 맞춰서 사용해야 한다.

    @PostMapping("") //post는 생성
    public RsData<Member> join(@RequestBody @Valid MemberJoinReqBody reqBody) {
        return memberService.join(reqBody.username, reqBody.password, reqBody.nickname);

    }

}
