package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.VideosFeed;
import com.ttk.exception.VideoNotFoundException;
import com.ttk.repository.VideoFeedRepository;
import com.ttk.service.VideoFeedService;


@Service
public class VideoFeedServiceImpl implements VideoFeedService{
	
	@Autowired
	 VideoFeedRepository vRepo;

	@Override
	public VideosFeed addVideos(VideosFeed video) {
		return vRepo.save(video);
	}

	@Override
	public VideosFeed getVideosFeedDetail(int videoid) {
		return vRepo.findById(videoid).orElseThrow(()-> new VideoNotFoundException("Video Id is nor corrected"));
	}

	@Override
	public VideosFeed updateVideosFeedDetail(VideosFeed video, int videoid) {
		VideosFeed UpdateVideosFeed = vRepo.findById(videoid).
				orElseThrow(()-> new VideoNotFoundException("video id is not corrected"));
		UpdateVideosFeed.setVtitle(video.getVtitle());
		UpdateVideosFeed.setVcontent(video.getVcontent());
		vRepo.save(UpdateVideosFeed);
		return UpdateVideosFeed;
		
	}

	@Override
	public void deleteVideosFeedDetail(int videoid) {
		VideosFeed delVideosFeed =vRepo.findById(videoid).
				orElseThrow(()-> new VideoNotFoundException("recipe id is not corrected"));
		vRepo.delete(delVideosFeed);
		
	}
		
}

