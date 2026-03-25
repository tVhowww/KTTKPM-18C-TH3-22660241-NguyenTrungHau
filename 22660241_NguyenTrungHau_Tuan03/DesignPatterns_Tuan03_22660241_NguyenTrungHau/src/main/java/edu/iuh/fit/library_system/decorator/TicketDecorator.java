package edu.iuh.fit.library_system.decorator;

public abstract class TicketDecorator implements BorrowTicket {
    protected BorrowTicket wrappedTicket;
    public TicketDecorator(BorrowTicket ticket) { this.wrappedTicket = ticket; }

    @Override public String getDescription() { return wrappedTicket.getDescription(); }
    @Override public double getFee() { return wrappedTicket.getFee(); }
}