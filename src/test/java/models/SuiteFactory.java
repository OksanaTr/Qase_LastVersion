package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class SuiteFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Suite fields with random values")
    public static Suite enterAllFieldOfTheSuite() {
        return Suite.builder()
                .suiteName(faker.lorem().word())
                .parentSuite(faker.expression("ShareLine"))
                .description(faker.lorem().fixedString(30))
                .preconditions(faker.lorem().fixedString(30))
                .build();
    }

    @Step("Fill in only the required suites field")
    public static Suite enterTheDataInTheRequiredFields() {
        return Suite.builder()
                .suiteName(faker.lorem().word())
                .build();
    }

}