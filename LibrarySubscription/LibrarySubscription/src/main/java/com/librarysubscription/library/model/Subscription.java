package com.librarysubscription.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

	public Subscription() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBSCRIBER_ID", unique = true, nullable = false)
	private int subscriberId;
	@Column(name = "SUBSCRIBER_NAME")
	private String subscriberName;
	@Column(name = "DATE_SUBSCRIBED")
	private String dateSubscribed;
	@Column(name = "DATE_RETURNED")
	private String dateReturned;
	@Column(name = "BOOK_ID")
	private String bookId;

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public String getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(String dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public String getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Subscription(String subscriberName, String dateSubscribed, String dateReturned, String bookId) {
		super();
		this.subscriberName = subscriberName;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberName=" + subscriberName + ", dateSubscribed=" + dateSubscribed + ", dateReturned="
				+ dateReturned + ", bookId=" + bookId + "]";
	}

//SUBSCRIPTION
//SUBSCRIBER_NAME	DATE_SUBSCRIBED	DATE_RETURNED	BOOK_ID
//John	12-JUN-2020		B1212
//Mark	26-APR-2020	14-May-2020	B4232
//Peter	22-JUN-2020		B1212

}
