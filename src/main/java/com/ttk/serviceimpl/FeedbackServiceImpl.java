package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.Feedback;
import com.ttk.exception.FeedbackNotFoundException;
import com.ttk.repository.FeedbackRepository;
import com.ttk.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepository fbRepo;
	@Override
	public Feedback addFeedback(Feedback feedback) {
		return fbRepo.save(feedback);
	}

	@Override
	public Feedback getFeedbackDetail(int feedbackid) {
		return fbRepo.findById(feedbackid).
				orElseThrow(()-> new FeedbackNotFoundException("Feedback Id is nor corrected"));
	}

	@Override
	public Feedback updateFeedbackDetail(Feedback feedback, int feedbackid) {
		
		Feedback UpdateFeedback = fbRepo.findById(feedbackid).
				orElseThrow(()-> new FeedbackNotFoundException("Feedbackid is not corrected"));
	
		UpdateFeedback.setFcontent(feedback.getFcontent());
		fbRepo.save(UpdateFeedback);
		return UpdateFeedback;
	}

	@Override
	public void deleteFeedbackDetail(int bookid) {
		Feedback delFeedback =fbRepo.findById(bookid).
				orElseThrow(()-> new FeedbackNotFoundException("Feedback id is not corrected"));
		fbRepo.delete(delFeedback);
	}

}
