package com.isra.springmongo.dto;

import java.util.ArrayList;
import java.util.List;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.domain.Client;
import com.isra.springmongo.domain.Rent;

public class BookStoreDTO {

	
	private String id;
	private String name;
	
	private List<Book> books = new ArrayList<Book>();
	
	private List<Client> clients = new ArrayList<Client>();
	
	private List<Rent> rents = new ArrayList<Rent>();
	
	public BookStoreDTO() {
	}
	
	public BookStoreDTO(BookStore obj) {
		id = obj.getId();
		name = obj.getName();
		books = obj.getBooks();
		clients = obj.getClients();
		rents = obj.getRents();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	
	
	
}
