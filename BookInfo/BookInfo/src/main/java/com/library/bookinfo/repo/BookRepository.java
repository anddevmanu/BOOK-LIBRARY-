package com.library.bookinfo.repo;

import org.springframework.data.repository.CrudRepository;

import com.library.bookinfo.model.Book;

public interface BookRepository extends CrudRepository<Book,String>{
	
	

}
