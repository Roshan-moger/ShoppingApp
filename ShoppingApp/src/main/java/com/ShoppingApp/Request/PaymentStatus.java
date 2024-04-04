package com.ShoppingApp.Request;

public enum PaymentStatus {
    SUCCESSFUL,
    AMOUNT_INVALID,
    BANK_FAILED,
    ORDER_INVALID,
    PAYMENT_SERVER_UNREACHABLE,
    ORDER_ALREADY_PAID
}
