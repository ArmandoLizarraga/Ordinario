package com.ordinario.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

}
