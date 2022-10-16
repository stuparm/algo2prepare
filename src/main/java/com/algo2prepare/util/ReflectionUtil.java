package com.algo2prepare.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Mihailo Stupar
 */
class ReflectionUtil {

     static <T> T newInstance(Class<T> clazz) {
        try {

            Class<?> enclosingClass = clazz.getEnclosingClass();
            if (enclosingClass != null) {

                Object enclosedInstance = enclosingClass.getDeclaredConstructor().newInstance();

                Constructor<T> constructor = clazz.getDeclaredConstructor(enclosingClass);
                constructor.setAccessible(true);
                T instance = constructor.newInstance(enclosedInstance);
                return instance;
            } else {
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                T instance = constructor.newInstance();
                return instance;
            }

        } catch (Exception e) {  throw new RuntimeException(e); }
    }


     static Object get(Field field, Object target) {
        try {
            Object result = field.get(target);
            return result;
        } catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }

     static void set(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) { throw new RuntimeException(e); }
    }

     static Field field(Class clazz, String... candidates) {
        for (int i = 0; i < candidates.length ; i++)
            try {
                Field field = clazz.getDeclaredField(candidates[i]);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) { // same as continue; }
        }
        return null; //field not found among candidates
    }

     static Field field(Object object, String... candidates) {
        return field(object.getClass(), candidates);
    }





}
