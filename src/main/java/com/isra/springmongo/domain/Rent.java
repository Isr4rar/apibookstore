package com.isra.springmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rent")
public class Rent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Client client;
	
	private List<Book> books = new ArrayList<Book>();
	
	private Date startDate;
	private Date devolutionDate;

	public Rent() {
	}
	
	public Rent(String id, Client client, Date startDate, Date devolutionDate) {
		super();
		this.id = id;
		this.client = client;
		this.startDate = startDate;
		this.devolutionDate = devolutionDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

}
