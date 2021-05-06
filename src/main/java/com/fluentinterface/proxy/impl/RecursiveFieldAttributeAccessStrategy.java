package com.fluentinterface.proxy.impl;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Strategy that sets the target bean's attributes directly using the Reflection API (without going
 * through the setters). It works up the hierarchy trying to find a field until it reaches the end
 * of the hierarchy or the specified class.
 */
public class RecursiveFieldAttributeAccessStrategy extends FieldAttributeAccessStrategy {

    private final Class<?> reflectUpToClass;

    public RecursiveFieldAttributeAccessStrategy(Class<?> reflectUpToClass) {
        this.reflectUpToClass = reflectUpToClass;
    }

    @Override
    protected Field getFieldFromClass(Class<?> clazz, String fieldName) {

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {

            if(f.getName().equals(fieldName)) {
                return f;
            }
        }

        if(clazz.equals(Objects.class) || clazz.equals(reflectUpToClass)) {
            return null;
        }

        return getFieldFromClass(clazz.getSuperclass(), fieldName);
    }
}
