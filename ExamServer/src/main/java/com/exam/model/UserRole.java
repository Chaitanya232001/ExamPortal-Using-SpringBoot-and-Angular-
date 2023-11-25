package com.exam.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRoldId;

    //user
    @ManyToOne( fetch = FetchType.EAGER)
    private Registration registration;

   @ManyToOne
    private SignIn signIn;

public Integer getUserRoldId() {
    return userRoldId;
}

public void setUserRoldId(Integer userRoldId) {
    this.userRoldId = userRoldId;
}

public Registration getRegistration() {
    return registration;
}

public void setRegistration(Registration registration) {
    this.registration = registration;
}

public SignIn getSignIn() {
    return signIn;
}

public void setSignIn(SignIn signIn) {
    this.signIn = signIn;
}

public UserRole() {
}   
}
