package com.example.bigwork.repository;

import com.example.bigwork.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CustomizedRepository<User, Integer>{
    @Query("SELECT u FROM User")
    List<User> findAll();

    @Query("SELECT u FROM User WHERE u.authority=0")
    List<User> findAllT();

    @Query("SELECT u FROM User WHEWE u.authority=1")
    List<User> findAllM();

    @Query("SELECT u FROM User u WHERE u.id=id")
    User findId(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.userName=:name")
    User findName(@Param("name") String name);

    @Modifying
    @Query(value="UPDATE User u set u=:user WHERE u.id=:uid",nativeQuery = true)
    User update(@Param("user") User user, @Param("uid") int uid);

    @Modifying
    @Query(value="UPDATE User u set u.authority=:a WHERE u.id=:uid",nativeQuery = true)
    User setAdmin(@Param("a") int authority, @Param("uid") int uid);

}
