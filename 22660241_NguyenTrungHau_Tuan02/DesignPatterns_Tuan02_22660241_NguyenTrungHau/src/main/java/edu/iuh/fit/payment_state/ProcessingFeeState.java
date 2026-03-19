package edu.iuh.fit.payment_state;

class ProcessingFeeState implements PaymentState {
    public void process(PaymentContext context) {
        System.out.println("Đang cộng phí xử lý...");
        context.setAmount(context.getAmount() * 1.02);
        // Lại phải chuyển trạng thái tiếp
        context.setState(new PaidState());
    }
}