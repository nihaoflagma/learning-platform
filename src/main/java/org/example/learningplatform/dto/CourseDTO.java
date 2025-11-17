// CourseDTO.java
package org.example.learningplatform.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private int duration;
    private LocalDate startDate;
    private Long teacherId;
    private String teacherName;
}