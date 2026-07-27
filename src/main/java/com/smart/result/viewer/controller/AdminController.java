package com.smart.result.viewer.controller;

import com.smart.result.viewer.dto.StudentForm;
import com.smart.result.viewer.entity.Mark;
import com.smart.result.viewer.entity.Student;
import com.smart.result.viewer.repository.StudentRepo;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private StudentRepo studentRepo;
    private ModelMapper modelMapper;

    public AdminController(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

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

    @PostMapping("/add-result-action")
    public String processAddResult(
           @Valid @ModelAttribute StudentForm studentForm,
           BindingResult bindingResult,
           Model model
    ) {

        if(bindingResult.hasErrors()){
            List<String> standardOptions = new ArrayList<>();
            standardOptions.add("CSE");
            standardOptions.add("CIVIL");
            standardOptions.add("EC");

            model.addAttribute("standardOptions" , standardOptions);
            return "admin/add result";
        }

        //convert student form to student entity

        Student student =  modelMapper.map(studentForm, Student.class);

        //har marks to attach student
        List<Mark> updatedList = student.getMarks().stream().map((Mark mark) -> {
            mark.setStudent(student);
            return mark;
        }).toList();

        //update student list
        student.setMarks(updatedList);

        student.setId(UUID.randomUUID().toString());
       studentRepo.save(student);
       return "redirect:/admin/add-result?message=Student added successfully";

    }
}
