package com.ttk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttk.entity.Feedback;
import com.ttk.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService fbservice;
	
	@PostMapping("/Feedback/addFeedback")
	public ResponseEntity<Feedback> saveCategory(@Valid @RequestBody Feedback feedback)
	{
		return new ResponseEntity<Feedback>(fbservice.addFeedback(feedback),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/Feedback/get/{feedbackid}")
	public ResponseEntity<Feedback> getFeedback(@PathVariable ("feedbackid") int feedbackid)
	{
		return new ResponseEntity<Feedback>(fbservice.getFeedbackDetail(feedbackid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/Feedback/remove/{feedbackid}")
	public ResponseEntity<String> deleteFeedback(@PathVariable ("feedbackid") int feedbackid)
	{
		fbservice.deleteFeedbackDetail(feedbackid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/Feedback/update/{Feedbackid}")
	public ResponseEntity<String> updateFeedback(@RequestBody Feedback feedback,@PathVariable("feedbackid") int feedbackid) 
	{
		fbservice.updateFeedbackDetail(feedback,feedbackid); // Delegate to service layer
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}

}
