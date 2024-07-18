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

import com.ttk.entity.FoodPhotos;
import com.ttk.service.FoodPhotosService;

import jakarta.validation.Valid;

@RestController
public class FoodPhotosController {

	@Autowired
	FoodPhotosService fservice;
	
	@PostMapping("/FoodPhotos/addPhoto")
	public ResponseEntity<FoodPhotos> saveFoodPhotos(@Valid @RequestBody FoodPhotos photo)
	{
		return new ResponseEntity<FoodPhotos>(fservice.addPhoto(photo),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	public ResponseEntity<FoodPhotos> getFoodPhotos(@PathVariable ("photoid") int photoid)
	{
		return new ResponseEntity<FoodPhotos>(fservice.getFoodPhotosDetail(photoid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/FoodPhotos/remove/{photoid}")
	public ResponseEntity<String> deleteFoodPhotos(@PathVariable ("photoid") int photoid)
	{
		fservice.deleteFoodPhotosDetail(photoid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/FoodPhotos/update/{photoid}")
	public ResponseEntity<String> updateFoodPhotos(@RequestBody FoodPhotos photo,@PathVariable("photoid") int photoid) {
	fservice.updateFoodPhotosDetail(photo,photoid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}
	
}