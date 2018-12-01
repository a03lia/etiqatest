package com.a03lia.university.frontend.controller;

import com.a03lia.university.frontend.model.StudentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author a03lia
 */
@Controller
public class HomeController
{
    @GetMapping({"/", "/index"})
    public String index(Model model)
    {
        model.addAttribute("studentForm", new StudentForm());
        return "index";
    }
}
