package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParamsConroller {
    @GetMapping("/getParamsOld")
    public String getParamsOld(HttpServletRequest request) {
        var param1 = request.getParameter("param1");
        var param2 = Integer.parseInt(request.getParameter("param2"));
        request.setAttribute("stringParam", param1);
        request.setAttribute("intParam", param2);
        return "main";
    }
}
