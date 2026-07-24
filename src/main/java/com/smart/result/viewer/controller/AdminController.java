package com.smart.result.viewer.controller;

import com.smart.result.viewer.dto.StudentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/add-result")
    public String addResult(Model model){
        StudentForm studentForm = new StudentForm();

        List<String> standardOptions = new ArrayList<>();
        standardOptions.add("CSE");
        standardOptions.add("CIVIL");
        standardOptions.add("EC");

        model.addAttribute("studentForm" , studentForm);
        model.addAttribute("standardOptions" , standardOptions);
        return "admin/add result";
    }
}
