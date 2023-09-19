package models;


import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class CaseFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Basic fields with random values")
    public static Case fillInAllFieldsOfBasicCase() {
        return Case.builder()
                .title(faker.hacker().verb())
                .status(faker.expression("Draft"))
                .description(faker.lorem().fixedString(20))
                .suite(faker.expression("Test cases without suite"))
                .type(faker.expression("Smoke"))
                .milestone(faker.expression("Not set"))
                .severity(faker.expression("Normal"))
                .layer(faker.expression("Not set"))
                .behavior(faker.expression("Positive"))
                .priority(faker.expression("High"))
                .is_Flaky(faker.expression("No"))
                .automationStatus(faker.expression("Not automated"))
                .title(faker.hacker().verb())
                .pre_Conditions(faker.lorem().fixedString(100))
                .post_Conditions(faker.lorem().fixedString(120))
                .select(faker.expression("class"))
                .parameterTitle(faker.lorem().fixedString(50))
                .parameterValues(faker.lorem().fixedString(20))
                 .stepAction(faker.lorem().fixedString(25))
                .data(faker.lorem().fixedString(10))
                .expectedResult(faker.lorem().fixedString(50))
                .build();
    }
}