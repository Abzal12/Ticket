import java.util.*;

public class Ticket {

    private final String ID = Generator.generateUniqueID();
    private final Date currentTime = new java.util.Date((long) System.currentTimeMillis());
    private String concertHall, eventCode;
    private double weight;
    private boolean isPromo;
    private char stadiumSector;
    private static final Map<String, Date> ticketCreatedTimes = new HashMap<>();

    public Ticket() {
        saveTime();
    }

    public Ticket(String concertHall, String eventCode, boolean isPromo, char stadiumSector, double maxWeight) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.weight = maxWeight;
        validateFullTicket();
        saveTime();
    }

    public Ticket(String concertHall, String eventCode) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        validateLimitedTicket();
        saveTime();
    }

    private void validateFullTicket() {
        if (concertHall.length() > 10) {
            throw new RuntimeException("Max 10 chars are allowed for the Concert hall's name.");
        } else if (!eventCode.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException("Only digits are allowed for the Event code.");
        } else if (eventCode.length() != 3) {
            throw new RuntimeException("Exact 3 digits are required for the Event code.");
        } else if (!(stadiumSector == 'A' || stadiumSector == 'B' || stadiumSector == 'C')) {
            throw new RuntimeException("There are only 'A', 'B', 'C' sectors.");
        }
    }

    private void validateLimitedTicket() {
        if (concertHall.length() > 10) {
            throw new RuntimeException("Max 10 chars are allowed for the Concert hall's name.");
        } else if (!eventCode.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException("Only digits are allowed for the Event code.");
        } else if (eventCode.length() != 3) {
            throw new RuntimeException("Exact 3 digits are required for the Event code.");
        }
    }

    private void saveTime() {
        ticketCreatedTimes.put(ID, currentTime);
    }

    @Override
    public String toString() {
        return  "ticket ID = '" + ID + '\'' +
                ",\nconcert hall = '" + concertHall + '\'' +
                ",\nevent code = '" + eventCode + '\'' +
                ",\ncreation time = " + currentTime +
                ",\nis it promo = " + isPromo +
                ",\nstadium sector = " + stadiumSector +
                ",\nweight = '" + Generator.convertKilogramsToKilogramsAndGrams(weight) + '\'' +
                "\n";
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        this.concertHall = concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxWeight() {
        return weight;
    }

    public void setMaxWeight(double maxWeight) {
        this.weight = maxWeight;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public String getID() {
        return ID;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public static Map<String, Date> getTicketCreatedTimes() {
        return ticketCreatedTimes;
    }
}
