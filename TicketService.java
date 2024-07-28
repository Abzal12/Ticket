import model.AbstractID;
import model.StadiumSector;
import model.Ticket;
import user.Admin;
import user.Client;

import java.math.BigDecimal;

public class TicketService extends AbstractID {
    public static void main(String[] args) {

        //creation of an empty ticket object
        Ticket emptyTicket = new Ticket();
        emptyTicket.print();

        //creation a client object
        Client Abzal = new Client();

        //Illustration of overriding method (= polymorphism approach)
        Abzal.printRole();
        Abzal.getTicket(emptyTicket);

        //illustration of overloading methods (= polymorphism approach)
        emptyTicket.shared("abz@mail.com");
        emptyTicket.shared(77777777);
        System.out.println();

        //creating an admin
        Admin niceAdmin = new Admin();
        //Illustration of overriding method (= polymorphism approach)
        niceAdmin.printRole();
        Abzal.showTicket();
        niceAdmin.checkTicket(emptyTicket);

        // ----------------------------------------------------------------------------------------------------
        //creation of a full ticket object
        String concertHall = "congr hall";
        String eventCode = "123";
        boolean isPromo = true;
        StadiumSector currentSector = StadiumSector.A;
        double maxWeight = 100.5;
        BigDecimal price = BigDecimal.valueOf(50);
        Ticket fullTicket = null;
        if (Ticket.isTicketValid(concertHall, eventCode)) {
            fullTicket = new Ticket(concertHall, eventCode, isPromo, currentSector, maxWeight, price);
            fullTicket.print();

            Client alien = new Client();
            alien.printRole();
            alien.getTicket(fullTicket);

            fullTicket.shared("alien@mail.com");
            fullTicket.shared(888888888);

            alien.showTicket();

            //Ticket fakeTicket = new Ticket("fake hall", "666", true, StadiumSector.C, 200.0, BigDecimal.valueOf(50));
            Ticket fakeTicket = alien.createFakeTicket("fake hall", "666", true, StadiumSector.C, 200.0, BigDecimal.valueOf(50));
            niceAdmin.checkTicket(fakeTicket);
        }

        // ----------------------------------------------------------------------------------------------------
        //creation of a limited ticket object
        String concertHall2 = "good hall";
        String eventCode2 = "456";
        BigDecimal price2 = BigDecimal.valueOf(150);
        Ticket limitedTicket = null;
        if (Ticket.isTicketValid(concertHall2, eventCode2)) {
            limitedTicket = new Ticket(concertHall2, eventCode2, price2);
            limitedTicket.print();

            Client ironMan = new Client();
            ironMan.getTicket(limitedTicket);

            limitedTicket.shared("ironman@mail.com");
            limitedTicket.shared(3000);

            niceAdmin.printRole();
            ironMan.showTicket();
            niceAdmin.checkTicket(limitedTicket);
        }

        //checking equals() and hashCode() for correctness:
        System.out.println("The result of comparing object with itself is " + emptyTicket.equals(emptyTicket));
        Ticket ticket2 = new Ticket();
        ticket2.setId(emptyTicket.getId());
        ticket2.setCurrentTime(emptyTicket.getCurrentTime());
        System.out.println("The result of comparing object with another object but with the same field values is " + emptyTicket.equals(ticket2));
        System.out.println("The result of comparing object with another object and different field values is " + limitedTicket.equals(fullTicket));
    }

    @Override
    public void print() {
        System.out.println("It is a main class that has a main method");
    }
}
