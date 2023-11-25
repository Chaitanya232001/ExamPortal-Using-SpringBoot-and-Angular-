package com.exam.service;

import com.exam.model.Registration;
import com.exam.model.UserRole;

import java.util.List;
import java.util.Set;

public interface RegistrationService {
   //creating user
    Registration createRegistration(Registration registration,Set<UserRole>userRole) throws Exception;
    
    //get registration by username
    public Registration getreRegistration(String username);

    //delete registration by id
     //public void deleteRegistration(Integer id);
      void deleteRegistration(Integer id);

     //updation
    void updatePassword(Registration registration);

    Registration getByEmail(String email);
    
    //view
    public List<Registration> showRegistrations();
}
