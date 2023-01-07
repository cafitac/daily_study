package chapter1;

public class Bag {

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(final long amount) {
        this(null, amount);
    }

    public Bag(final Invitation invitation, final long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void plusAmount(final Long amount) {
        this.amount += amount;
    }

    public Long hold(final Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(final Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(final Long amount) {
        this.amount -= amount;
    }
}
