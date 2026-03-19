package edu.iuh.fit.payment_state;

class DiscountState implements PaymentState {
    public void process(PaymentContext context) {
        System.out.println("Đang trừ tiền giảm giá...");
        context.setAmount(context.getAmount() - 50000);
        // Bắt buộc phải chuyển sang trạng thái tiếp theo (Tính phí)
        context.setState(new ProcessingFeeState());
    }
}