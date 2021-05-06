package com.fluentinterface.domain;

import java.util.List;

import com.fluentinterface.ReflectionBuilder;
import com.fluentinterface.builder.Builder;
import com.fluentinterface.proxy.impl.RecursiveFieldAttributeAccessStrategy;

/**
 * @author plitvak
 */
public class GenericModel<T> {

    private String id;
    private List<T> values;

    public GenericModel(GenericModel<T> other) {
        this.id = other.id;
        this.values = other.values;
    }

    public interface GenericModelBuilder<T> extends Builder<GenericModel<T>> {
        GenericModelBuilder<T> withId(String id);
        GenericModelBuilder<T> withValues(List<T> values);
    }

    public static <T> GenericModelBuilder<T> builder() {
        return ReflectionBuilder
            .implementationFor(GenericModelBuilder.class)
            .usingAttributeAccessStrategy(new RecursiveFieldAttributeAccessStrategy(GenericModel.class))
            .create();
    }

    public String getId() {
        return id;
    }

    public List<T> getValues() {
        return values;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private GenericModel() {
    }
}
