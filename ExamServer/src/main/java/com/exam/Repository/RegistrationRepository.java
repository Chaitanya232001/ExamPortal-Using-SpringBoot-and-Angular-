package com.exam.Repository;

import com.exam.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    public Registration findByUsername(String username);
    public Registration findByEmail(String email);
   
}
