package user;

import lombok.Getter;
import lombok.Setter;
import model.BasicModel;
import model.Ticket;

@Setter
@Getter
public class Client extends BasicModel implements User {

    private Ticket ticket;
    private static long counter = 0;

    public Client() {
        setId(++counter);
        System.out.printf("Creating a client with an ID %d ...\n", this.getId());
    }

    @Override
    public void printRole() {
        System.out.println("A role for the current object is a " + Role.CLIENT);
    }

    //here it is not a usual 'get' method. Here it is more like buy/acquire a ticket
    public void buyTicket(Ticket ticket) {
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
