package com.bank.model.dao;

import com.bank.model.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<CustomUser, Integer>{

    @Query("select u from CustomUser u where u.login = :login")
    CustomUser getUserByLogin(@Param("login") String login);

    @Query("select u from CustomUser u where u.name = :name and u.surname = :surname")
    List<CustomUser> getByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("select u from CustomUser u where u.email = :email")
    List<CustomUser> getByEmail(@Param("email") String email);

    @Query("select case when count(u) > 0 then true else false end from CustomUser u where u.login = :login ")
    boolean isUserExist(@Param("login") String login);

    @Query("select u from CustomUser u where u.email = :email")
    List<CustomUser> findCustomUsersByEmail(@Param("email") String email);
}
