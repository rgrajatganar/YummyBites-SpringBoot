package com.ttk.service;

import com.ttk.entity.Feedback;

public interface FeedbackService {
	
	Feedback addFeedback(Feedback feedback);

	// method to fetch User detail based on uid from db table
	Feedback getFeedbackDetail(int feedbackid);

	//method to modify User detail based on uid from db table
	Feedback updateFeedbackDetail(Feedback feedback, int feedbackid);

	//method to remove User detail based on uid from db table
	void deleteFeedbackDetail(int feedbackid);

}
