package com.library.subscriberinfo.exception;

public class SubscriberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SubscriberNotFoundException() {
		super("Subscriber not Exist");
	}
}

