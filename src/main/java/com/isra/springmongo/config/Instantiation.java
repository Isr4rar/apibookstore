package com.isra.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.domain.Client;
import com.isra.springmongo.domain.Rent;
import com.isra.springmongo.repository.BookRepository;
import com.isra.springmongo.repository.BookStoreRepository;
import com.isra.springmongo.repository.ClientRepository;
import com.isra.springmongo.repository.RentRepository;

@Configuration
public class Instantiation  implements CommandLineRunner {

	
	@Autowired
	private ClientRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	@Autowired
	private RentRepository rentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		bookRepository.deleteAll();
		bookStoreRepository.deleteAll();
		rentRepository.deleteAll();
		
		Book book_1 = new Book(null, "Star Wars - Marcas da Guerra", "Wendig, Chuck", 2015, 25.44);
		Book book_2 = new Book(null, "Star Wars - Darth Plagueis", "Luceno, James", 2012, 22.99);
		Book book_3 = new Book(null, "Star Wars - Troopers da Morte", "Schreiber, Joe", 2015, 28.99);
		
		bookRepository.saveAll(Arrays.asList(book_1, book_2, book_3));
		
		Client israel = new Client(null, "Maria Eduarda", "Duda@gmail.com");
		Client gabriel = new Client(null, "Gabriel Araujo", "gabriel@gmail.com");
		Client lucas = new Client(null, "Lucas Araujo", "lucas@gmail.com");
		
		userRepository.saveAll(Arrays.asList(israel, gabriel, lucas));
		
		Rent rent_1 = new Rent(null, israel, sdf.parse("10/10/2018"), sdf.parse("15/10/2018"));
		Rent rent_2 = new Rent(null, gabriel, sdf.parse("11/10/2018"), sdf.parse("16/10/2018"));
		Rent rent_3 = new Rent(null, lucas, sdf.parse("12/10/2018"), sdf.parse("17/10/2018"));
		
		rent_1.getBooks().add(book_2);
		rent_2.getBooks().add(book_1);
		rent_3.getBooks().add(book_3);
		
		
		rentRepository.saveAll(Arrays.asList(rent_1, rent_2, rent_3));
		
		
		BookStore bookStore = new BookStore(null, "Livraria Digivox");
		
		bookStore.getBooks().addAll(Arrays.asList(book_1, book_2, book_3));
		bookStore.getClients().addAll(Arrays.asList(israel, gabriel, lucas));
		bookStore.getRents().addAll(Arrays.asList(rent_1, rent_2, rent_3));
		
		
		
		bookStoreRepository.save(bookStore);
	}
	


}
