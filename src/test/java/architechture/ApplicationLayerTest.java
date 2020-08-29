package architechture;

import com.woody.ddd.blogcleanarchitechture.application.usecases.UseCase;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ApplicationLayerTest extends ArchitechtureTest {
    @Test
    void use_cases_should_be_named_ending_with_UseCase() {
        classes().that().implement(UseCase.class)
            .should().haveSimpleNameEndingWith("UseCase")
            .as("The use cases should be named ending with 'UseCase'.")
            .check(classes);
    }

    @Test
    void use_cases_should_implement_UseCase() {
        classes()
            .that().haveSimpleNameEndingWith("UseCase")
            .and().areNotInterfaces()
            .should().implement(UseCase.class)
            .as("The use cases should implement 'UseCase' interface.")
            .check(classes);
    }

    @Test
    void use_cases_should_place_under_usecases_package() {
        classes()
            .that().implement(UseCase.class)
            .should().resideInAPackage("..application.usecases..")
            .as("The use cases should place under usecases package.")
            .check(classes);
    }
}
