package generator_methods;

import model.BasicModel;

public class Generator extends BasicModel {

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
