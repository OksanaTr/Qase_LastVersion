package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class ProjectFactory {
    public static Project enterRandomFieldModalProjectPage() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String fakerCode = fakeValuesService.regexify("[A-Z]{10}");
        return Project.builder()
                .title(faker.company().name())
                .projectCode(fakerCode)
                .description("Create new project")
                .access("Private")
                .group("Don't add members")
                .build();
    }
}