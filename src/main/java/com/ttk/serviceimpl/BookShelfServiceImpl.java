package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.BookShelf;
import com.ttk.exception.BookShelfNotFoundException;
import com.ttk.repository.BookShelfRepository;
import com.ttk.service.BookShelfService;


@Service
public class BookShelfServiceImpl implements BookShelfService{

	@Autowired
	BookShelfRepository bRepo;
	@Override
	public BookShelf addBook(BookShelf book) {
		return bRepo.save(book);
	}

	@Override
	public BookShelf getBookShelfDetail(int bookid) {
		return bRepo.findById(bookid).orElseThrow(()-> new BookShelfNotFoundException("Book Id is nor corrected"));
	}

	@Override
	public BookShelf updateBookShelfDetail(BookShelf book, int bookid) {
		
		BookShelf UpdateBookShelf = bRepo.findById(bookid).
				orElseThrow(()-> new BookShelfNotFoundException("Bookid is not corrected"));
	
		UpdateBookShelf.setBtitle(book.getBtitle());
		UpdateBookShelf.setBauthor(book.getBauthor());
		bRepo.save(UpdateBookShelf);
		return UpdateBookShelf;
	}

	@Override
	public void deleteBookShelfDetail(int bookid) {
		BookShelf delBookShelf =bRepo.findById(bookid).
				orElseThrow(()-> new BookShelfNotFoundException("Book id is not corrected"));
		bRepo.delete(delBookShelf);
	}

}

	
	
