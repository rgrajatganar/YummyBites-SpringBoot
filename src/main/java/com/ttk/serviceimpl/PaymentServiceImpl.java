package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.FoodPhotos;
import com.ttk.entity.Payment;
import com.ttk.exception.FoodPhototosNotFoundException;
import com.ttk.exception.PaymentNotFoundException;
import com.ttk.repository.PaymentRepository;
import com.ttk.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository pRepo;

	@Override
	public Payment addPayment(Payment payment) {
		return pRepo.save(payment);
	}

	@Override
	public Payment getPaymentDetail(int paymentid) {
		return pRepo.findById(paymentid).orElseThrow(()-> new PaymentNotFoundException("Payment Id is nor corrected"));

	}

	@Override
	public Payment updatePaymentDetail(Payment payment, int paymentid) {
		Payment UpdatePayment = pRepo.findById(paymentid).
				orElseThrow(()-> new PaymentNotFoundException("Payment id is not corrected"));
	
		UpdatePayment.setAmount(payment.getAmount());
		UpdatePayment.setPaymentDetails(payment.getPaymentDetails());
		pRepo.save(UpdatePayment);
		return UpdatePayment;
	}

	@Override
	public void deletePaymentDetail(int paymentid) {
		Payment delPayment =pRepo.findById(paymentid).
				orElseThrow(()-> new PaymentNotFoundException("Payment id is not corrected"));
		pRepo.delete(delPayment);
		
	}
	
	

}
