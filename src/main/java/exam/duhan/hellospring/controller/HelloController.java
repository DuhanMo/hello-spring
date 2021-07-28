package exam.duhan.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", required = false) String name, Model model) {

        model.addAttribute("msg", name);


        return "hello";
    }
}
