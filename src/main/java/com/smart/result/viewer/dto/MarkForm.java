package com.smart.result.viewer.dto;

import com.smart.result.viewer.entity.Student;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarkForm {

    private String subjectName;
    private String marks;
    private String maxMarks;
    private String feedback;
    private String grade;

    private StudentForm student;

}