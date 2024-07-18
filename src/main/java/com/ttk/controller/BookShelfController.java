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

import com.ttk.entity.BookShelf;
import com.ttk.service.BookShelfService;

import jakarta.validation.Valid;

@RestController
public class BookShelfController {
	
	
	@Autowired
	BookShelfService bservice;
	
	@PostMapping("/BookShelf/addBook")
	public ResponseEntity<BookShelf> saveBookShelf(@Valid @RequestBody BookShelf book)
	{
		return new ResponseEntity<BookShelf>(bservice.addBook(book),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/BookShelf/get/{uid}")
	public ResponseEntity<BookShelf> getBookShelf(@PathVariable ("bookid") int bookid)
	{
		return new ResponseEntity<BookShelf>(bservice.getBookShelfDetail(bookid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/BookShelf/remove/{bookid}")
	public ResponseEntity<String> deleteBookShelf(@PathVariable ("bookid") int bookid)
	{
		bservice.deleteBookShelfDetail(bookid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/BookShelf/update/{bookid}")
	public ResponseEntity<String> updateBookShelf(@RequestBody BookShelf book,@PathVariable("bookid") int bookid) {
	bservice.updateBookShelfDetail(book,bookid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);

	}

}
