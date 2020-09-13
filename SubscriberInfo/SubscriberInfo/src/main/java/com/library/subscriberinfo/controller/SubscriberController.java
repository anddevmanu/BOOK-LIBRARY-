package com.library.subscriberinfo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.subscriberinfo.exception.SubscriberNotFoundException;
import com.library.subscriberinfo.model.Subscription;
import com.library.subscriberinfo.repo.SubscriberRepo;


@RestController
@RequestMapping("subscription")
public class SubscriberController {

	@Autowired
	SubscriberRepo subscriberRepository;
	
	@GetMapping("{subscriberId}")
	public Subscription getBook(@PathVariable String subscriberId){
		System.out.println("00000000000000000000");
		return subscriberRepository.findById(subscriberId).orElseThrow(SubscriberNotFoundException::new);
		
	}
	
	@GetMapping
	public Iterable<Subscription> getBooks(){
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		return subscriberRepository.findAll();
		
	}
	
	@PostMapping("/{bookId}/{userName}")
	public Subscription saveBook(@PathVariable String bookId,@PathVariable String userName){
		
		Subscription subscription=new Subscription();
		subscription.setBookId(bookId);
		subscription.setDateSubscribed(new Date().toString());
		subscription.setSubscriberName("manu");
		subscription.setSubscriberName(userName);
		System.out.println("00000000000000000000");
		return subscriberRepository.save(subscription);
		
	}
	
	
}