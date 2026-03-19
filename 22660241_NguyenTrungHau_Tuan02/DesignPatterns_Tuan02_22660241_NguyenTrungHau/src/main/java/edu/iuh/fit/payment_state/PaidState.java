package edu.iuh.fit.payment_state;

class PaidState implements PaymentState {
    public void process(PaymentContext context) {
        System.out.println("Thanh toán hoàn tất: " + context.getAmount());
    }
}