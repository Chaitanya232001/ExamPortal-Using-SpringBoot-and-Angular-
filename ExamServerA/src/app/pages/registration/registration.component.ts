import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationsService } from '../../services/registrations.service';
import { error } from 'console';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent {
  Registration = {
    username: '',
    firstName: '',
    lastName: '',
    phone: '',
    profile: '',
    password: '',
    email: '',
  };

  constructor(
    public registrations: RegistrationsService,
    private router: Router
  ) {}

  formSubmit() {
    this.router.navigate(['/sign-in']);
    if (
      this.Registration.username === '' ||
      this.Registration.username === null
    ) {
      alert('Username is required!!');
      return;
    }

    //adduser(registrations: RegistrationsService)
    this.registrations.addUser(this.Registration).subscribe(
      (data) => {
        //success
        this.Registration.firstName = '';
        this.Registration.lastName = '';
        this.Registration.email = '';
        this.Registration.username = '';
        this.Registration.password = '';
        this.Registration.phone = '';
        alert("Success','You have succesfully registered','success'");
      },
      (error) => {
        alert('Username is already Exist,please try another Username!');
      }
    );
  }
}
