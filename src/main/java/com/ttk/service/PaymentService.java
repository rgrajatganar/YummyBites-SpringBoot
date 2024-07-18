package com.ttk.service;

import com.ttk.entity.Payment;

public interface PaymentService {
	
	Payment addPayment(Payment payment);

	// method to fetch User detail based on uid from db table
	Payment getPaymentDetail(int paymentid);

	//method to modify User detail based on uid from db table
	Payment updatePaymentDetail(Payment payment, int paymentid);

	//method to remove User detail based on uid from db table
	void deletePaymentDetail(int paymentid);

}
