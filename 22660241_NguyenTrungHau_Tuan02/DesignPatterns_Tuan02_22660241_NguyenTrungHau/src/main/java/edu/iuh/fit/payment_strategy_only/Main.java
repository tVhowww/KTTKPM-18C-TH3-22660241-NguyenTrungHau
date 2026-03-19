//package edu.iuh.fit.payment_strategy_only;
//
//interface PaymentStrategy { void pay(double amount); }
//
//// Các class cơ bản (Tốt)
//class NormalPayPal implements PaymentStrategy { ... }
//class NormalCreditCard implements PaymentStrategy { ... }
//
//// BẮT ĐẦU CƠN ÁC MỘNG TỔ HỢP CLASS:
//class PayPalWithDiscount implements PaymentStrategy { ... }
//class CreditCardWithDiscount implements PaymentStrategy { ... }
//
//class PayPalWithFee implements PaymentStrategy { ... }
//class CreditCardWithFee implements PaymentStrategy { ... }
//
//// Lỡ khách vừa có giảm giá, vừa bị tính phí? Phải tạo class mới!
//class PayPalWithDiscountAndFee implements PaymentStrategy { ... }
//class CreditCardWithDiscountAndFee implements PaymentStrategy { ... }
//
//// => Nếu tương lai có thêm "Tích điểm", số lượng class sẽ nhân lên theo cấp số nhân!