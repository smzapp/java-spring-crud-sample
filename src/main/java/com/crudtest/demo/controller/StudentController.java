package com.crudtest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping("")
    public String index() {
        return "woww";
    }

    @GetMapping("/item")
    public String item() {
        return "item";
    }

}
