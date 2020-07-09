package com.example.petshop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.model.Pet;

/**
 * @author Bhavani Kyatham
 *
 */
@Repository
public interface PetDao extends CrudRepository<Pet, Integer> {
	@Query(value = "select * from Pet p where p.pet_name like %:petName%",nativeQuery = true)
	Optional<List<Pet>> getPetsByPetName(String petName);
	@Query(value = "select * from Purchase p where p.pet_id like %:petId% and p.user_id like %:userId%",nativeQuery = true)
	public Optional<Pet> findByUserIdAndPetId(int userId, int petId);

}
