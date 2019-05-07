package it.contrader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	//public User findUserByUsernameAndPassword(String username,String password);
	public List<User> findAllByUsername(String username);
	
	
	public User  findUserByUsernameAndPassword(String username,String password);
}
