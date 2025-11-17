package org.example.learningplatform.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleDTO {
    private Long id;
    private String title;
    private int orderIndex;
    private Long courseId;
}
