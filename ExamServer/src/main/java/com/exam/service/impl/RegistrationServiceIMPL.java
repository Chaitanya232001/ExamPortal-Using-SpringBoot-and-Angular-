package com.exam.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam.Repository.RegistrationRepository;
import com.exam.Repository.SignInRepository;
import com.exam.model.Registration;
import com.exam.model.UserRole;
import com.exam.service.RegistrationService;

import java.util.List;
import java.util.Set;

@Service
public class RegistrationServiceIMPL implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired 
    private SignInRepository signInRepository;

    

 @Override
    public Registration createRegistration(Registration registration, Set<UserRole> userRole) throws Exception {
        Registration local= this.registrationRepository.findByUsername(registration.getUsername());
        if(local!=null){
         System.out.println("User is already there!!");
         throw new Exception("User already present!!");
        }else{
         //user created
         for (UserRole ur:userRole){
             signInRepository.save(ur.getSignIn());
         }
         registration.getUserRole().addAll(userRole);
         local=this.registrationRepository.save(registration);
        }
        return local;
    }


    // @Override
    // public void deleteRegistration(Integer id) {
    //     registrationRepository.deleteById(id);
    // }
    @Override
    public void deleteRegistration(Integer id) {
        this.registrationRepository.deleteById(id);
    }


    @Override
    public void updatePassword(Registration registration) {
        Registration existingUser = registrationRepository.findByEmail(registration.getEmail());
        if (existingUser != null) {
            existingUser.setNewPassword(registration.getNewPassword());
            registrationRepository.save(existingUser);
        }
    }

    @Override
    public Registration getreRegistration(String username) {
        return this.registrationRepository.findByUsername(username);
    }


    @Override
    public Registration getByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }


    @Override
    public List<Registration> showRegistrations() {
        return registrationRepository.findAll();
    }

}
