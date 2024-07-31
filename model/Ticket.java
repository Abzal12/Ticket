package model;
import annotation.Checker;
import annotation.NullableWarning;
import generator_methods.Generator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
public class Ticket extends BasicModel {

    private LocalDateTime currentTime = LocalDateTime.now();

    @Setter(AccessLevel.NONE)
    @NullableWarning
    private String concertHall;

    @Setter(AccessLevel.NONE)
    @NullableWarning
    private String eventCode;

    @Setter(AccessLevel.NONE)
    @NullableWarning
    private double weight;

    @Setter(AccessLevel.NONE)
    @NullableWarning
    private boolean isPromo;

    @NullableWarning
    private StadiumSector stadiumSector;

    @Setter(AccessLevel.NONE)
    @NullableWarning
    private BigDecimal price;

    private static long counter = 0;

    //for checking a ticket I chose to create 'produced tickets'
    public final static List<Ticket> producedTickets = new ArrayList<>();

    public Ticket() {
        System.out.println("\nCreating an 'empty' ticket ...");
        this.setId(++counter);
        Checker.checkNullWarnings(this);
        producedTickets.add(this);
    }

    public Ticket(String concertHall, String eventCode, boolean isPromo, StadiumSector stadiumSector, double maxWeight, BigDecimal price) {
        System.out.println("\nCreating a 'full' ticket ...");
        this.setId(++counter);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.weight = maxWeight;
        this.price = price;
        Checker.checkNullWarnings(this);
        producedTickets.add(this);
    }

    public Ticket(String concertHall, String eventCode, BigDecimal price) {
        System.out.println("\nCreating a 'limited' ticket ...");
        this.setId(++counter);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.price = price;
        Checker.checkNullWarnings(this);
        producedTickets.add(this);
    }

    public static boolean isTicketValid(String concertHall, String eventCode) {
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

    public void shared(String email, long telNumber) {
        shared(email);
        System.out.println("Sending an electronic ticket details as a SMS message with an ID '" + this.getId() + "' and a link to the QR code  to the telephone number: " + telNumber);
    }

    public void shared(String email) {
        System.out.println("An electronic ticket details with an ID '" + this.getId() + "' and its QR code has been sent to the email: " + email);
    }

    @Override
    public void print() {
        System.out.println("Printing a ticket details to the console ...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "Ticket ID: " + this.getId() +
                ",\nConcert hall: " + concertHall +
                ",\nEvent code: " + eventCode +
                ",\nCreation time: " + currentTime +
                ",\nIs it promo: " + isPromo +
                ",\nStadium sector: " + stadiumSector +
                ",\nMaximum allowed weight: " + Generator.convertKilogramsToKilogramsAndGrams(weight) +
                ",\nTicket price = $" + price +
                "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), currentTime, concertHall, eventCode, weight, isPromo, stadiumSector, price);
    }

    @Override
    public boolean equals(Object currentObj) {
        if (currentObj == this) {
            return true;
        }
        if (!(currentObj instanceof Ticket other)) {
            return false;
        }
        return this.getId() == other.getId() &&
                Double.compare(other.weight, weight) == 0 &&
                isPromo == other.isPromo &&
                Objects.equals(currentTime, other.currentTime) &&
                Objects.equals(concertHall, other.concertHall) &&
                Objects.equals(eventCode, other.eventCode) &&
                Objects.equals(stadiumSector, other.stadiumSector) &&
                Objects.equals(price, other.price);
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
