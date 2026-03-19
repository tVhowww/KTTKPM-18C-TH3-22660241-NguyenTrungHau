package edu.iuh.fit.payment_state;

class PaymentContext {
    private PaymentState state;
    private double amount = 1000000;

    public PaymentState getState() {
        return state;
    }

    public double getAmount() {
        return amount;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void pay() {
        state.process(this); // Gọi 1 lần chỉ chạy 1 trạng thái, muốn chạy hết phải dùng vòng lặp rất vô lý!
    }
}
