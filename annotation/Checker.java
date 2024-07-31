package annotation;

import model.BasicModel;

import java.lang.reflect.Field;

public class Checker extends BasicModel {

    public static void checkNullWarnings(Object currentObj) {
        for (Field field : currentObj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(currentObj) == null) {
                        System.out.println("Variable [" + field.getName() + "] is null in [" + currentObj.getClass().getName() + "]!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void print() {
        System.out.println("This class has a checkNullWarnings(Object currentObj) method.");
    }
}
