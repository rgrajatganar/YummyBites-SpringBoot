package com.ttk.service;

import com.ttk.entity.FoodPhotos;

public interface FoodPhotosService {
	
	FoodPhotos addPhoto(FoodPhotos photo);

	// method to fetch User detail based on uid from db table
	FoodPhotos getFoodPhotosDetail(int photoid);

	//method to modify User detail based on uid from db table
	FoodPhotos updateFoodPhotosDetail(FoodPhotos photo, int photoid);

	//method to remove User detail based on uid from db table
	void deleteFoodPhotosDetail(int photoid);

}
