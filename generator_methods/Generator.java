package generator_methods;

import model.AbstractID;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator extends AbstractID {

    public static String convertKilogramsToKilogramsAndGrams(double kilograms) {
        int kg = (int) kilograms;
        int grams = (int) ((kilograms - kg) * 1000);

        return kg + " kilograms and " + grams + " grams";
    }

    @Override
    public void print() {
        System.out.println("This Generator class has one method called convertKilogramsToKilogramsAndGrams(double kg)");
    }

}
