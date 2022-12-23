package com.baldcharm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDocumentsController {
    @GetMapping("/documents")
    public String getDocumentsPage() {
        return "admin/documents";
    }
}
