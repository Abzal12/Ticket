import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {
    private static final int ID_LENGTH = 4;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();
    private static final Set<String> GENERATED_IDS = new HashSet<>();

    public static String generateUniqueID() {
        StringBuilder id;
        do {
            id = new StringBuilder(ID_LENGTH);
            for (int i = 0; i < ID_LENGTH; i++) {
                id.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
            }
        } while (GENERATED_IDS.contains(id.toString()));
        GENERATED_IDS.add(id.toString());
        return id.toString();
    }

    public static String convertKilogramsToKilogramsAndGrams(double kilograms) {
        int kg = (int) kilograms;
        int grams = (int) ((kilograms - kg) * 1000);

        return kg + " kilograms and " + grams + " grams";
    }
}
