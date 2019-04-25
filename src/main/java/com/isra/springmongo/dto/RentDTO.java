package com.isra.springmongo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.domain.Client;
import com.isra.springmongo.domain.Rent;

public class RentDTO {
	
	private String id;
	private Client client;
	
	private List<Book> books = new ArrayList<Book>();
	
	private Date startDate;
	private Date devolutionDate;
	
	
	public RentDTO() {
	}
	
	public RentDTO(Rent obj) {
		id = obj.getId();
		client = obj.getClient();
		books = obj.getBooks();
		startDate = obj.getStartDate();
		devolutionDate = obj.getDevolutionDate();
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
