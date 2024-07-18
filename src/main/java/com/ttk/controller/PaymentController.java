package com.ttk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttk.entity.Payment;
import com.ttk.service.PaymentService;

import jakarta.validation.Valid;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService pService;
	
	@PostMapping("/Payment/addPayment")
	public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment)
	{
		return new ResponseEntity<Payment>(pService.addPayment(payment),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	public ResponseEntity<Payment> getFoodPhotos(@PathVariable ("paymentid") int paymentid)
	{
		return new ResponseEntity<Payment>(pService.getPaymentDetail(paymentid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/Payment/remove/{paymentid}")
	public ResponseEntity<String> deleteFoodPhotos(@PathVariable ("paymentid") int paymentid)
	{
		pService.deletePaymentDetail(paymentid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/Payment/update/{paymentid}")
	public ResponseEntity<String> updatePayment(@RequestBody Payment payment,@PathVariable("paymentid") int paymentid) {
	pService.updatePaymentDetail(payment,paymentid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}
}
