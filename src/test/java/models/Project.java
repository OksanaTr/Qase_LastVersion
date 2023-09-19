package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Project {
    String title;
    String projectCode;
    String description;
    String access;
    String group;
}
