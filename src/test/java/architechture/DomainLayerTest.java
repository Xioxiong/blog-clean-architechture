package architechture;

import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.AggregateRoot;
import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.Entity;
import com.woody.ddd.blogcleanarchitechture.domain.core.concepts.ValueObject;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainLayerTest extends ArchitechtureTest {
    @Test
    void domain_layer_depend_on_rule() {
        classes()
            .that().resideInAPackage("..domain..")
            .should().onlyDependOnClassesThat().resideInAnyPackage("java..", "..domain..")
            .as("The domain layer should only depend on the classes in the package of " +
                "java and domain.")
            .check(classes);
    }

//    @Test
//    void domain_layer_implement_and_extend_rule() {
//        classes()
//            .that().resideInAPackage("..domain..")
//
//            // these lines use to ignore lombok's @SuperBuilder generated code
////            .and().haveSimpleNameNotEndingWith("CriteriaBuilderImpl")
////            .and().haveSimpleNameNotEndingWith("CriteriaBuilder")
//
//            .should().implement(Entity.class)
//            .orShould().implement(AggregateRoot.class)
//            .orShould().implement(ValueObject.class)
//            .as("The models in the domain should implement or extend one of the interfaces / classes in " +
//                "Entity, AggregateRoot, ValueObject, ReadModel, WriteModel, " +
//                "Service, Policy, Factory, Repository, DomainException, Criteria.")
//            .check(classes);
}
