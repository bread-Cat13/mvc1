package com.example.mvc.review.Controller;



import com.example.mvc.review.MyController;
import com.example.mvc.review.member.Member;
import com.example.mvc.review.member.MemberRepository;

import java.util.Map;

public class SaveController implements MyController {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        Member member = new Member(paramMap.get("username"), Integer.parseInt(paramMap.get("age")));
        memberRepository.save(member);
        model.put("member", member);

        return "save-result";
    }
}
