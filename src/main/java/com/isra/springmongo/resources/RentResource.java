package com.isra.springmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isra.springmongo.domain.Rent;
import com.isra.springmongo.dto.RentDTO;
import com.isra.springmongo.services.RentService;

@RestController
@RequestMapping(value="/rents")
public class RentResource {
	
	@Autowired
	private RentService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<RentDTO>>  findAll(){
		List<Rent> list = service.findAll();
		List<RentDTO> listDto = list.stream().map(x -> new RentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<RentDTO>  findById(@PathVariable String id){
		Rent obj = service.findById(id);
		return ResponseEntity.ok().body(new RentDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody RentDTO objDto){
		Rent obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Void>  delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void>  update(@RequestBody RentDTO objDto, @PathVariable String id){
		Rent obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
