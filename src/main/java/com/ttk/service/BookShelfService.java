package com.ttk.service;

import com.ttk.entity.BookShelf;

public interface BookShelfService {
	
	// save User details in db table
				BookShelf addBook(BookShelf book);

				// method to fetch User detail based on uid from db table
				BookShelf getBookShelfDetail(int bookid);

				//method to modify User detail based on uid from db table
				BookShelf updateBookShelfDetail(BookShelf book, int bookid);

				//method to remove User detail based on uid from db table
				void deleteBookShelfDetail(int bookid);

}
