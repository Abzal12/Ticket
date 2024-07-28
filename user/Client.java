package user;

import lombok.Getter;
import lombok.Setter;
import model.AbstractID;
import model.StadiumSector;
import model.Ticket;

import java.math.BigDecimal;

@Setter
@Getter
public class Client extends AbstractID implements User {

    private Ticket ticket;
    private static long counter = 0;

    public Client() {
        setId(++counter);
        System.out.printf("Creating a client with an ID %d ...\n", this.getId());
    }

    public Ticket createFakeTicket(String concertHall, String eventCode, boolean isPromo, StadiumSector stadiumSector, double maxWeight, BigDecimal price) {
        Ticket fakeTicket = new Ticket(concertHall, eventCode, isPromo, stadiumSector, maxWeight, price);
        Ticket.producedTickets.removeLast();
        return fakeTicket;
    }

    @Override
    public void printRole() {
        System.out.println("A role for the current object is a " + Role.CLIENT);
    }

    //here it is not a usual 'get' method. Here it is more like buy/acquire a ticket
    public void getTicket(Ticket ticket) {
        System.out.println("A current client is purchasing a ticket ...");
        this.ticket = ticket;
    }

    public void showTicket() {
        System.out.println("A client showing a ticket with an ID ... " + ticket.getId());
    }

    @Override
    public void print() {
        System.out.println("It is a Client object. It has several methods like printRole(), getTicket(), showTicket()");
    }
}
