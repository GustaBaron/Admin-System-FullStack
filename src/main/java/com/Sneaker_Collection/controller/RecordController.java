package com.Sneaker_Collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {

    @GetMapping("/")
    public String showRecordListPage() {
        return "index";
    }

    @GetMapping("/create")
    public String showCreateRecordPage() {
        return "create-record";
    }
}