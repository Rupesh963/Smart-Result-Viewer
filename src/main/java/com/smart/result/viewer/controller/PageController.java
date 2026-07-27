package com.smart.result.viewer.controller;

import com.smart.result.viewer.dto.RequestResultForm;
import com.smart.result.viewer.entity.Mark;
import com.smart.result.viewer.entity.Student;
import com.smart.result.viewer.repository.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    private StudentRepo studentRepo;

    public PageController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @RequestMapping("/")
    public String index(){
        return "Index";
    }

    @GetMapping("/view-result")
    public String viewResult(Model model){

        RequestResultForm requestResultForm = new RequestResultForm();
        model.addAttribute( "requestResultForm", requestResultForm);
        return "view result";
    }

    @PostMapping("/view-result")
    public String viewResult(

            @Valid @ModelAttribute RequestResultForm requestResultForm,
            BindingResult bindingResult,
            Model model

    ) {

        if (bindingResult.hasErrors()) {
            return "view result";
        }

        // result fetch and then view send

        Optional<Student> optionalStudent = studentRepo.findByRollNumberAndDateOfBirth(requestResultForm.getRollNumber(), requestResultForm.getDateOfBirth());
        if(optionalStudent.isEmpty()){
            return "redirect:/view result ? message=Student not found !!";
        }

        Student student = optionalStudent.get();
        List<Mark> marks = student.getMarks();

        int totalMarks = 0;
        int totalMaxMarks = 0;

        for (Mark mark : marks) {

            totalMarks += Integer.parseInt(mark.getMarks());
            totalMaxMarks += Integer.parseInt(mark.getMaxMarks());

        }

        double percentage = (double) totalMarks / totalMaxMarks * 100;

        String result = percentage >= 33 ? "Passed" : "Failed";

        model.addAttribute("student", student);
        model.addAttribute("marks", marks);

        model.addAttribute("totalMarks", totalMarks);
        model.addAttribute("totalMaxMarks", totalMaxMarks);

        model.addAttribute("percentage",
                String.format("%.2f", percentage));

        model.addAttribute("result", result);

        return "result";
    }
}
