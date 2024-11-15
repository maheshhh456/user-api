//package com.example.userapi.repository;
//
//import com.example.userapi.entity.UserEntity;
//import com.example.userapi.modal.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<UserEntity, Long> {
//}
//package com.example.userapi.repository;
//
//import com.example.userapi.entity.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    // Custom query methods can go here if needed
//}
//package com.example.userapi.repository;
//
//import com.example.userapi.entity.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<UserEntity, Long> {
//}
//
package com.example.userapi.repository;
import com.example.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Query method to find a user by email
    UserEntity findByEmail(String email);
}
