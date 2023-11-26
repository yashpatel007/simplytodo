package com.simplytodo.repository;

import com.simplytodo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(int id);
    public Optional<User> findByEmail(String email);
    public void deleteById(int id);
    public User save(User user);
    public List<User> findAll();


    /*@Query("#{userQueryProvider.getUserByNameAndPhone(:name,:phone)}") // SpEL
    public List<User> getUserByNameAndPhoneSPEL(@Param("name") String name,@Param("phone") String phone);*/
}
