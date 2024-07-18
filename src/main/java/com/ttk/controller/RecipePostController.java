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

import com.ttk.entity.RecipePost;
import com.ttk.service.RecipePostService;

import jakarta.validation.Valid;

@RestController
public class RecipePostController {
	
	@Autowired
	RecipePostService rservice;
	
	@PostMapping("/RecipePost/addRecipe")
	public ResponseEntity<RecipePost> saveRecipePost(@Valid @RequestBody RecipePost recipe)
	{
		return new ResponseEntity<RecipePost>(rservice.addRecipe(recipe),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/RecipePost/get/{recipeid}")
	public ResponseEntity<RecipePost> getRecipePost(@PathVariable ("recipeid") int recipeid)
	{
		return new ResponseEntity<RecipePost>(rservice.getRecipePostDetail(recipeid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/RecipePost/remove/{recipeid}")
	public ResponseEntity<String> deleteRecipePost(@PathVariable ("recipeid") int recipeid)
	{
		rservice.deleteRecipePostDetail(recipeid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/RecipePost/update/{recipeid}")
	public ResponseEntity<String> updateRecipePost(@RequestBody RecipePost recipe,@PathVariable("recipeid") int recipeid) 
	{
		rservice.updateRecipePostDetail(recipe,recipeid); // Delegate to service layer
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}
	
	

}
