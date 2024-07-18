/*package com.ttk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserException(UserNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleRecipePostException(RecipeNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(VideoNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleVideosFeedException(VideoNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(FoodPhototosNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFoodPhotosException(FoodPhototosNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFeedbackException(FeedbackNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCategoryException(CategoryNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
	
	@ExceptionHandler(BookShelfNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBookShelfException(BookShelfNotFoundException tx, WebRequest request )
	{
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
}
*/