package it.contrader.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	//public User findUserByUsernameAndPassword(String username,String password);
	public List<User> findAllByUsername(String username);
	
	
	public User findUserByUsernameAndPassword(String username,String password);
	
	@Modifying(clearAutomatically = true)
	@org.springframework.transaction.annotation.Transactional
	@Query(value = "update User u set u.type=:TYPE where u.id_user=:ID", nativeQuery = true)
	public void assignById(@Param("ID") int id,@Param("TYPE") String type);
}
