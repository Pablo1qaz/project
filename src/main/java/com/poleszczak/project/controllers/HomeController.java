package com.poleszczak.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/"})
    public String home(){
        return "home";
    }

    @GetMapping({"/contact"})
    public String contact() {
        return "contact";
    }

    @GetMapping({"/planner"})
    public String planner() {
        return "planner";
    }


    @GetMapping({"/tasks"})
    public String tasks() { return "tasks"; }

    @GetMapping({"/guests"})
    public String guests() { return "guests"; }

    @GetMapping({"/tables"})
    public String tables() { return "tables"; }

    @GetMapping({"/forum"})
    public String forum() { return "forum"; }






}
