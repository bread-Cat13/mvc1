package com.example.mvc.review.Controller;


import com.example.mvc.review.MyController;

import java.util.Map;

public class NewFormController implements MyController {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
