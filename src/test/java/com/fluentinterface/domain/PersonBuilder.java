package com.fluentinterface.domain;

import java.util.Collection;
import java.util.Queue;

import com.fluentinterface.builder.Builder;

public interface PersonBuilder extends Builder<Person> {

    PersonBuilder withName(String name);

    PersonBuilder withAge(int age);

    PersonBuilder forAge(int age);

    PersonBuilder withAge(String age);

    PersonBuilder withPartner(PersonBuilder diane);

    PersonBuilder withSurnames(String... surnames);

    PersonBuilder withFriends(Person... friends);

    PersonBuilder withFriends(PersonBuilder... friendsBuilders);

    PersonBuilder withFriends(Collection<PersonBuilder> builderCollection);

    PersonBuilder withParents(Collection<Person> builderCollection);

    PersonBuilder withParents(PersonBuilder... parents);

    PersonBuilder withAgesOfMarriages(int... agesOfMarriages);

    /** Setting unknown properties will fail. */
    PersonBuilder withAnUnknownProperty(String value);

    /** Method names must represent property name starting from first uppercase character. */
    PersonBuilder something(String name);

    /** Queues are supported only for direct assignment (target class property must also be a Queue). */
    PersonBuilder withQueue(Queue queue);
}
