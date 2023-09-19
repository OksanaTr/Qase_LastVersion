package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Suite {
    String suiteName;
    String parentSuite;
    String description;
    String preconditions;
}