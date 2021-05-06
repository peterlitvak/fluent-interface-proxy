package com.fluentinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fluentinterface.domain.GenericModel;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author plitvak
 */
public class GenericModelBuilderTest {

    @Test
    public void testGenericBuilder() {

        GenericModel<String> genericModelOne =
            GenericModel.<String>builder().withId("aaa").withValues(Collections.singletonList("123")).build();
        assertEquals("aaa", genericModelOne.getId());
        assertEquals(1, genericModelOne.getValues().size());

        List<List<String>> lst = new ArrayList<>();
        lst.add(Collections.singletonList("123"));
        GenericModel<List<String>> genericModelTwo =
            GenericModel.<List<String>>builder().withId("aaa").withValues(lst).build();
        assertEquals("aaa", genericModelTwo.getId());
        assertEquals(1, genericModelTwo.getValues().size());
    }
}
