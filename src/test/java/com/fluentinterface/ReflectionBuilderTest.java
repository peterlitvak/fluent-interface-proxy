package com.fluentinterface;

import java.io.Serializable;

import com.fluentinterface.builder.Builder;
import com.fluentinterface.domain.Person;
import org.junit.Test;

import static com.fluentinterface.ReflectionBuilder.implementationFor;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

public class ReflectionBuilderTest {

    @Test
    public void shouldImplyBuiltClassFromSingleBuilderInterface() {

        ReflectionBuilder<PersonBuilder> reflectionBuilder = implementationFor(PersonBuilder.class);

        assertThat(reflectionBuilder.getBuiltClass(), typeCompatibleWith(Person.class));
    }

    @Test
    public void shouldImplyBuiltClassFromMultipleBuilderInterface() {

        ReflectionBuilder<PersonWithAnotherInterfaceBuilder> reflectionBuilder = implementationFor(PersonWithAnotherInterfaceBuilder.class);

        assertThat(reflectionBuilder.getBuiltClass(), typeCompatibleWith(Person.class));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotImplyBuiltClassFromNoInterfaceAtAll() {

        ReflectionBuilder<DefinitelyNotABuilder> reflectionBuilder = implementationFor(DefinitelyNotABuilder.class);

        reflectionBuilder.getBuiltClass();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotImplyBuiltClassFromMultipleNonBuilderInterfaces() {

        ReflectionBuilder<NotABuilder> reflectionBuilder = implementationFor(NotABuilder.class);

        reflectionBuilder.getBuiltClass();
    }

    private static interface PersonBuilder extends Builder<Person> {}

    private static interface PersonWithAnotherInterfaceBuilder extends Serializable, Builder<Person> {}

    private static interface NotABuilder extends Serializable, Comparable {}

    private static interface DefinitelyNotABuilder {}
}