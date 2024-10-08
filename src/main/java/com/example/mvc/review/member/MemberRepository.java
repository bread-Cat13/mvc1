package com.example.mvc.review.member;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //singleton (spring 없이)
    @Getter
    private static final MemberRepository instance = new MemberRepository();

    public MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
         return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
