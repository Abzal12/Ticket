package model;
import generator_methods.Generator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Ticket {

    private final String ID = Generator.generateUniqueID();
    private final LocalDateTime currentTime = LocalDateTime.now();
    private String concertHall;
    private String eventCode;
    private double weight;
    private boolean isPromo;
    private StadiumSector stadiumSector = StadiumSector.A;
    private static final Map<String, Date> ticketCreatedTimes = new HashMap<>();
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(String concertHall, String eventCode, boolean isPromo, StadiumSector stadiumSector, double maxWeight, BigDecimal price) {
        if (!isTicketValid(concertHall, eventCode)) {

        } else {
            this.concertHall = concertHall;
            this.eventCode = eventCode;
            this.isPromo = isPromo;
            this.stadiumSector = stadiumSector;
            this.weight = maxWeight;
            this.price = price;
        }

    }

    public Ticket(String concertHall, String eventCode, BigDecimal price) {
        if (!isTicketValid(concertHall, eventCode)) {

        } else {
            this.concertHall = concertHall;
            this.eventCode = eventCode;
            this.price = price;
        }
    }

    private boolean isTicketValid(String concertHall, String eventCode) {
        if (concertHall.length() > 10) {
            System.out.println("Max 10 chars are allowed for the Concert hall's name.");
            return false;
        } else if (!eventCode.chars().allMatch(Character::isDigit)) {
            System.out.println("Only digits are allowed for the Event code.");
            return false;
        } else if (eventCode.length() != 3) {
            System.out.println("Exact 3 digits are required for the Event code.");
            return false;
        } else {
            return true;
        }
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
                ",\nticket price = $" + price +
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
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

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
