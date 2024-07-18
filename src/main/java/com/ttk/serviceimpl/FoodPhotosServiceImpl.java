package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.FoodPhotos;
import com.ttk.exception.FoodPhototosNotFoundException;
import com.ttk.repository.FoodPhotosRepository;
import com.ttk.service.FoodPhotosService;

@Service
public class FoodPhotosServiceImpl implements FoodPhotosService {

	@Autowired
	FoodPhotosRepository fRepo;
	
	@Override
	public FoodPhotos addPhoto(FoodPhotos photo) {
		return fRepo.save(photo);
	}

	@Override
	public FoodPhotos getFoodPhotosDetail(int photoid) {
		return fRepo.findById(photoid).orElseThrow(()-> new FoodPhototosNotFoundException("Photo Id is nor corrected"));
	}

	@Override
	public FoodPhotos updateFoodPhotosDetail(FoodPhotos photo, int photoid) {
		
		FoodPhotos UpdateFoodPhotos = fRepo.findById(photoid).
				orElseThrow(()-> new FoodPhototosNotFoundException("Photo id is not corrected"));
	
		UpdateFoodPhotos.setPtitle(photo.getPtitle());
		UpdateFoodPhotos.setPdescription(photo.getPdescription());
		fRepo.save(UpdateFoodPhotos);
		return UpdateFoodPhotos;
	}

	@Override
	public void deleteFoodPhotosDetail(int photoid) {
		FoodPhotos delFoodPhotos =fRepo.findById(photoid).
				orElseThrow(()-> new FoodPhototosNotFoundException("Photo id is not corrected"));
		fRepo.delete(delFoodPhotos);
	}

}
