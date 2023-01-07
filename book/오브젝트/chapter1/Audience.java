package chapter1;

public class Audience {

    private Bag bag;

    public Audience(final Bag bag) {
        this.bag = bag;
    }

    public Long buy(final Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.minusAmount(ticket.getFee());
            bag.setTicket(ticket);
            return ticket.getFee();
        }
    }
}
