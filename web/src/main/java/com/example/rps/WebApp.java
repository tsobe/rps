package com.example.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Beka Tsotsoria
 */
@Controller
@SpringBootApplication
public class WebApp {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/game/{name}")
    public String game(@PathVariable String name, ModelMap model) {
        model.addAttribute("game", name);
        return "game";
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}