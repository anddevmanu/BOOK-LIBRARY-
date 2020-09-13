package com.library.subscriberinfo.repo;

import org.springframework.data.repository.CrudRepository;

import com.library.subscriberinfo.model.Subscription;

public interface SubscriberRepo extends CrudRepository<Subscription,String>{

}
