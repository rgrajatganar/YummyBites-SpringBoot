package com.ttk.service;

import com.ttk.entity.VideosFeed;

public interface VideoFeedService {
	
	VideosFeed addVideos(VideosFeed video);

	// method to fetch video detail based on uid from db table
	VideosFeed getVideosFeedDetail(int videoid);

	//method to modify video detail based on uid from db table
	VideosFeed updateVideosFeedDetail(VideosFeed video, int videoid);

	//method to remove video detail based on uid from db table
	void deleteVideosFeedDetail(int videoid);

}
