package edu.iuh.fit.library_system.decorator;

public class ExtensionDecorator extends TicketDecorator {
    public ExtensionDecorator(BorrowTicket ticket) { super(ticket); }

    @Override public String getDescription() { return super.getDescription() + " + [Gia hạn thêm 7 ngày]"; }
    @Override public double getFee() { return super.getFee() + 2000; } // Phí gia hạn
}