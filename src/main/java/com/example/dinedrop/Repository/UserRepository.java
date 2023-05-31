package com.example.dinedrop.Repository;


import com.example.dinedrop.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}