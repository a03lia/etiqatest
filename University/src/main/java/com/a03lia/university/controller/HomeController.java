package com.a03lia.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author a03lia
 */
@Controller
public class HomeController
{
    @GetMapping({"/", "/index"})
    public String index()
    {
        return "index";
    }
}
