package com.smart.result.viewer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResultForm {

    @NotBlank(message = "Enter Roll Number !!")
    private String rollNumber;
    //@NotBlank(message = "Enter Date of Birth !!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
