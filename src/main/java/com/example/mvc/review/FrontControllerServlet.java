package com.example.mvc.review;


import com.example.mvc.review.Controller.ListController;
import com.example.mvc.review.Controller.NewFormController;
import com.example.mvc.review.Controller.SaveController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServlet", urlPatterns = "/my-review/*")
public class FrontControllerServlet extends HttpServlet {
    private final Map<String,MyController> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/my-review/members/new-form",new NewFormController());
        controllerMap.put("/my-review/members/save", new SaveController());
        controllerMap.put("/my-review/members", new ListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Service Method is running");
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        MyController controller = getController(request);
        if (controller == null) {
            System.out.println("No Controller Matched");
            return;
        } else {
            System.out.println("FrontControllerServlet.service");
        }

        Map<String, String> paramMap = createParamMap(request);

        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);

        System.out.println("viewName = " + viewName);

        My_View view = viewResolver(viewName);

        String viewPath = view.getViewPath();
        System.out.println("viewPath = " + viewPath);

        view.render(model, request, response);

        System.out.println("request = " + request);


    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));
        return paramMap;
    }

    private static My_View viewResolver(String viewName) {
        return new My_View("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyController getController(HttpServletRequest request) {
        return controllerMap.get(request.getRequestURI());
    }
}
