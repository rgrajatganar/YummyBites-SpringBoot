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

import com.ttk.entity.Category;
import com.ttk.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@PostMapping("/Category/addCategory")
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category)
	{
		return new ResponseEntity<Category>(cservice.addCategory(category),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/Category/get/{categoryid}")
	public ResponseEntity<Category> getCategory(@PathVariable ("categoryid") int categoryid)
	{
		return new ResponseEntity<Category>(cservice.getCategoryDetail(categoryid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/Category/remove/{categoryid}")
	public ResponseEntity<String> deleteCategory(@PathVariable ("categoryid") int categoryid)
	{
		cservice.deleteCategoryDetail(categoryid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/Category/update/{categoryid}")
	public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable("categoryid") int categoryid) 
	{
		cservice.updateCategoryDetail(category,categoryid); // Delegate to service layer
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	}
}
