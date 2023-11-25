package com.exam.Repository;

import com.exam.model.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignInRepository extends JpaRepository<SignIn, Integer> {
   
}
