package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/getParamsSpring")
    public String getParamsSpring(
            @RequestParam(name = "param1") String name,
            @RequestParam(name = "param2") int age,
            HttpServletRequest request) {
        request.setAttribute("stringParam", name);
        request.setAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/getParamsRequired")
    public String getParamsRequired(
            @RequestParam(name = "param1") String name,
            @RequestParam(name = "param2", required = false) Integer age,
            HttpServletRequest request) {
        request.setAttribute("stringParam", name);
        request.setAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/getParamsToSession")
    public String getParamsToSession(
            @RequestParam(name = "param1") String name,
            @RequestParam(name = "param2") int age,
            HttpSession session) {
        session.setAttribute("stringParam", name);
        session.setAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/getParamsFromPath/{param1}/{param2}")
    public String getParamsFromPath(
            @PathVariable(name = "param1") String name,
            @PathVariable(name = "param2") int age,
            Model model) {
        model.addAttribute("stringParam", name);
        model.addAttribute("intParam", age);
        return "main";
    }

    @GetMapping("/getParamsToModelAndView")
    public ModelAndView getParamsToModelAndView(
            @RequestParam(name = "param1") String name,
            @RequestParam(name = "param2") int age) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("stringParam", name);
        modelAndView.addObject("intParam", age);
        return modelAndView;
    }
}
