package user;

import model.BasicModel;
import model.Ticket;

public class Admin extends BasicModel implements User{

    private static long counter = 0;
    public Admin() {
        this.setId(++counter);
        System.out.printf("Creating an admin with an ID %d...\n", this.getId());
    }

    @Override
    public void printRole() {
        System.out.println("A role for the current object is an " + Role.ADMIN);
    }

    public void checkTicket(Ticket clientTicket) {
        System.out.println("The current admin is checking this ticket that has an ID " + clientTicket.getId() + " for correctness");
        boolean isTicketProper = false;
        for (Ticket producedTicket : Ticket.producedTickets) {
            if (producedTicket.equals(clientTicket)) {
                isTicketProper = true;
                break;
            }
        }

        if (isTicketProper) {
            System.out.println("The client is allowed to attend the event!");
        } else {
            System.out.println("Your ticket is fake. Get out of here! :\\");
        }
    }

    @Override
    public void print() {
        System.out.println("It is an Admin object. It has several methods like printRole(), checkTicket()");
    }
}
