/*
 * COPYRIGHT:     Copyright (c) 2015 by CCC, Inc.
 * Warning:       This product is protected by United States copyright law.
 *                Unauthorized use or duplication of this software, in whole 
 *                or in part, is prohibited.
 */
package com.fluentinterface;

import static org.junit.Assert.assertEquals;

import com.fluentinterface.domain.SubModel;
import org.junit.Test;

/**
 * @author plitvak
 */
public class SubSuperTest {

    @Test
    public void testMixinBuild() {

        SubModel model = SubModel.builder().withId("1").withDeleted(false).name("xxx").build();

        assertEquals("1", model.getId());
        assertEquals(false, model.isDeleted());
        assertEquals("xxx", model.getName());
    }
}
