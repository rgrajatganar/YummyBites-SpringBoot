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

import com.ttk.entity.VideosFeed;
import com.ttk.service.VideoFeedService;

import jakarta.validation.Valid;

@RestController
public class VideoFeedController {
	
	@Autowired
	VideoFeedService vservice;
	
	@PostMapping("/VideoFeed/addVideo")
	public ResponseEntity<VideosFeed> saveRecipePost(@Valid @RequestBody VideosFeed video)
	{
		return new ResponseEntity<VideosFeed>(vservice.addVideos(video),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/VideoFeed/get/{videoid}")
	public ResponseEntity<VideosFeed> getRecipePost(@PathVariable ("videoid") int videoid)
	{
		return new ResponseEntity<VideosFeed>(vservice.getVideosFeedDetail(videoid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/VideoFeed/remove/{videoid}")
	public ResponseEntity<String> deleteVideosFeed(@PathVariable ("videoid") int videoid)
	{
		vservice.deleteVideosFeedDetail(videoid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/VideoFeed/update/{videoid}")
	public ResponseEntity<String> updateRecipePost(@RequestBody VideosFeed video,@PathVariable("videoid") int videoid) 
	{
		vservice.updateVideosFeedDetail(video, videoid); // Delegate to service layer
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}

}
