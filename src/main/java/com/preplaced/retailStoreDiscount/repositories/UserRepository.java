package com.preplaced.retailStoreDiscount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.preplaced.retailStoreDiscount.model.User;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from User where id=:id", nativeQuery = true)
    User findById(Long id);
//    @Query(value = "select * from User where id=:userId", nativeQuery = true)
//    User findById(Integer userId);

}
