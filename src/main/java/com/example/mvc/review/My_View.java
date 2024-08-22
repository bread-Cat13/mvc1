package com.example.mvc.review;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Map;

@Getter @Setter
public class My_View {
    private final String viewPath;

    public My_View(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        model.forEach((k, v)-> request.setAttribute(k, v));

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        System.out.println("My_View.render");
        dispatcher.forward(request, response);
    }
}
