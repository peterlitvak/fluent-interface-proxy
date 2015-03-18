/*
 * COPYRIGHT:     Copyright (c) 2015 by CCC, Inc.
 * Warning:       This product is protected by United States copyright law.
 *                Unauthorized use or duplication of this software, in whole 
 *                or in part, is prohibited.
 */
package com.fluentinterface.domain;

import com.fluentinterface.builder.FluentSetter;

/**
 * @author plitvak
 */
abstract public class BaseModel {

    private String id;
    private boolean deleted;

    public String getId() {
        return id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public static interface BaseModelBuilderMixin<B> {

        public
        @FluentSetter
        B withId(String id);

        public
        @FluentSetter
        B withDeleted(boolean deleted);
    }
}
