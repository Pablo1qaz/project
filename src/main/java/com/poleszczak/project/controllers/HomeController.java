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

    @GetMapping({"/halls"})
    public String halls() {
        return "halls";
    }

    @GetMapping({"/photographer"})
    public String photographer() {
        return "photographer";
    }

    @GetMapping({"/dj"})
    public String dj() {
        return "dj";
    }

    @GetMapping({"/car"})
    public String car() {
        return "car";
    }

    @GetMapping({"/makeup"})
    public String makeup() {
        return "makeup";
    }

    @GetMapping({"/decorations"})
    public String decorations() {
        return "decorations";
    }

    @GetMapping({"/cameraman"})
    public String cameraman() { return "cameraman"; }

    @GetMapping({"/dresses"})
    public String dresses() { return "dresses"; }

    @GetMapping({"/suits"})
    public String suits() { return "suits"; }

    @GetMapping({"/invitations"})
    public String invitations() { return "invitations"; }

    @GetMapping({"/rings"})
    public String rings() { return "rings"; }

    @GetMapping({"/gifts"})
    public String gifts() { return "gifts"; }

    @GetMapping({"/tasks"})
    public String tasks() { return "tasks"; }

    @GetMapping({"/guests"})
    public String guests() { return "guests"; }

    @GetMapping({"/tables"})
    public String tables() { return "tables"; }

    @GetMapping({"/forum"})
    public String forum() { return "forum"; }

    @GetMapping({"/thread"})
    public String thread() { return "thread"; }





}
