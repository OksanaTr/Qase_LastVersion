package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Case {
    String title;
    String status;
    String description;
    String suite;
    String type;
    String milestone;
    String severity;
    String layer;
    String behavior;
    String priority;
    String is_Flaky;
    String automationStatus;
    String pre_Conditions;
    String post_Conditions;
    String select;
    String parameterTitle;
    String parameterValues;
    String stepAction;
    String data;
    String expectedResult;

}