package com.librarysubscription.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.librarysubscription.library.model.Book;
import com.librarysubscription.library.exception.BookNotFoundException;

@RestController
public class LibraryController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate res;

//		@Autowired
//		private CurrencyExchangeServiceProxy proxy;

	

	@GetMapping("/subscriptionbook/{bookId}/{userName}")

	public String librarySubscription(@PathVariable String bookId, @PathVariable String userName)
			throws BookNotFoundException {

		System.out.println("+++++++++++++++++++++++++++++++++++++");
		// ResponseEntity<Book[]> res = new
		// RestTemplate().getForEntity("http://localhost:8081/books/"+bookId,Book[].class);

//		String result = new RestTemplate().getForObject("http://localhost:8081/books/" + bookId, String.class);
		String result = res.getForObject("http://Book-Info/books/" + bookId, String.class);
		System.out.println(
				"************$$$$$$$$$$$$$################@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("----------------%%%%%%%%%%%%%%%%%------>  " + result);

//			Book  result2 = new RestTemplate().getForObject("http://localhost:8081/books/"+bookId,Book.class);
//	        System.out.println("************$$$$$$$$$$$$$################@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//			System.out.println("----------------%%%%%%%%%%%%%%%%%------>  "+result2);
//			

		// Book[] book = res.getBody();
		/*
		 * for(int i=0;i<book.length;i++) {
		 * System.out.println("=============---====="+book[i]); }
		 */

		System.out
				.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbb");
		if (result.contains("Exist")) {

			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			return "Book Not Found";

		} else {
			ObjectMapper objectMapper = new ObjectMapper();
			Book book = null;
			try {
				book = objectMapper.readValue(result, Book.class);

			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("BOOK_ID", book.getBookId());

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);

			String url = "http://Subscription-Info/subscription/" + book.getBookId() + "/" + userName;
			ResponseEntity<String> response = res.postForEntity(url, request, String.class);

			System.out.println(url + "");
			String res = response.getBody();

//		String uri = new String("");

			return res;
		}

	}

}
