package com.baldcharm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsController {
    @GetMapping("/documents")
    public String getDocumentsPage(Model model) {
        return "documents";
    }
}
