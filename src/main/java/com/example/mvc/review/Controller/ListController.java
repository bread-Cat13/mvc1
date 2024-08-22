package com.example.mvc.review.Controller;



import com.example.mvc.review.MyController;
import com.example.mvc.review.member.Member;
import com.example.mvc.review.member.MemberRepository;

import java.util.List;
import java.util.Map;

public class ListController implements MyController {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> memberList = memberRepository.findAll();
        model.put("members", memberList);

        return "members";
    }
}
