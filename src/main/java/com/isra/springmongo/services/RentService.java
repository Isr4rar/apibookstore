package com.isra.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isra.springmongo.domain.Rent;
import com.isra.springmongo.dto.RentDTO;
import com.isra.springmongo.repository.RentRepository;
import com.isra.springmongo.services.exception.ObjectNotFoundException;

@Service
public class RentService {

	@Autowired
	private RentRepository repo;

	public List<Rent> findAll(){
		return repo.findAll();
	}

	public Rent findById(String id) {
		Optional<Rent> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Rent insert(Rent obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Rent update(Rent obj) {
		Rent newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(Rent newObj, Rent obj) {
		newObj.setClient(obj.getClient());
		newObj.setStartDate(obj.getStartDate());
		newObj.setDevolutionDate(obj.getDevolutionDate());
	}

	public Rent fromDTO(RentDTO objDto) {
		return new Rent(objDto.getId(), objDto.getClient(), objDto.getStartDate(), objDto.getDevolutionDate());
	}
}
