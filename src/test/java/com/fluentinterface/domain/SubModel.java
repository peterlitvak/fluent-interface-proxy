/*
 * COPYRIGHT:     Copyright (c) 2015 by CCC, Inc.
 * Warning:       This product is protected by United States copyright law.
 *                Unauthorized use or duplication of this software, in whole 
 *                or in part, is prohibited.
 */
package com.fluentinterface.domain;

import com.fluentinterface.ReflectionBuilder;
import com.fluentinterface.builder.Builder;
import com.fluentinterface.proxy.impl.RecursiveFieldAttributeAccessStrategy;

/**
 * @author plitvak
 */
public class SubModel extends BaseModel {

    private String name;

    public String getName() {
        return name;
    }

    public static interface SubModelBuilder
            extends Builder<SubModel>, BaseModelBuilderMixin<SubModelBuilder> {

        public SubModelBuilder name(String name);
    }

    public static SubModelBuilder builder() {

        return ReflectionBuilder.implementationFor(SubModelBuilder.class)
                .usingAttributeAccessStrategy(
                        new RecursiveFieldAttributeAccessStrategy(BaseModel.class))
                .create();
    }

    private SubModel() {
    }
}
