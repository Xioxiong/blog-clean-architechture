package architechture;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayeredArchitectureTest extends ArchitechtureTest {
    @Test
    void layer_dependencies_must_be_respected_include_the_tests() {
        layeredArchitecture()
            .layer("Adapter").definedBy("com.woody.ddd.blogcleanarchitechture.adapter..")
            .layer("Application").definedBy("com.woody.ddd.blogcleanarchitechture.application..")
            // 由于Domain层位于最内层，可以被所有其它层访问，所以在此不用显式声明和进行测试
            // .layer("Domain").definedBy("study.huhao.demo.domain..")

            .whereLayer("Adapter").mayNotBeAccessedByAnyLayer()
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Adapter")
            // 由于Domain层位于最内层，可以被所有其它层访问，所以在此不用显式声明和进行测试
            // .whereLayer("Domain").mayOnlyBeAccessedByLayers("Adapters", "Application")

            .as("The layer dependencies must be respected")
            .because("we must follow the DIP principle.")
            .check(classes);
    }
}
