package com.library.bookinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.bookinfo.exception.BookNotFoundException;
import com.library.bookinfo.model.Book;
import com.library.bookinfo.repo.BookRepository;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable String bookId){
		System.out.println("00000000000000000000");
		
			Book book=	bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
			
			System.out.println("###########################################"+book);
			return book;
		
	}
	
	@GetMapping
	public Iterable<Book> getBooks(){
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		return bookRepository.findAll();
		
	}
}
