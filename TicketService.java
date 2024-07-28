import model.StadiumSector;
import model.Ticket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class TicketService {
    public static void main(String[] args) {

        //creation of an empty ticket object
        Ticket emptyTicket = new Ticket();
        System.out.println(emptyTicket);

        //creation of a full ticket object
        Ticket fullTicket = new Ticket("congr hall", "123", true, StadiumSector.A, 100.5, new BigDecimal("50"));
        System.out.println(fullTicket);

        //creation of a limited ticket object
        Ticket limitedTicket = new Ticket("good hall", "456", new BigDecimal("150"));
        System.out.println(limitedTicket);

    }
}
