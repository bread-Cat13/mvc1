package com.example.mvc.review;

import java.util.Map;

public interface MyController {
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
